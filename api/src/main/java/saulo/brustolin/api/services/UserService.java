package saulo.brustolin.api.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import saulo.brustolin.api.configurations.RabbitMQConfig;
import saulo.brustolin.api.dtos.users.UpdateUserDTO;
import saulo.brustolin.shared.dtos.UserEvent;
import saulo.brustolin.shared.dtos.VerificationCodeEvent;
import saulo.brustolin.api.exceptions.ValidationException;
import saulo.brustolin.api.entities.User;
import saulo.brustolin.api.mappers.UserMapper;
import saulo.brustolin.api.repositories.UserRepository;
import saulo.brustolin.api.utils.CodeGenerator;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final CodeGenerator codeGenerator;
    private final RabbitTemplate rabbitTemplate;
    private final VerificationCodeService verificationCodeService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @CachePut(value = "users", key = "#result.id")
    public User update(User user, UpdateUserDTO dto) {
        Boolean passwordMatch = passwordEncoder.matches(dto.currentPassword(), user.getPassword());
        if (!passwordMatch) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "currentPassword", "A senha atual não é a mesma da sua conta");
        }
        boolean isValid = verificationCodeService.validateCode(user.getId(), dto.code());
        if (!isValid) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "code", "O código de verificação é inválido.");
        }

        if (dto.password() != null && !dto.password().isBlank()) {
            if (!dto.password().equals(dto.confirmPassword())) {
                throw new ValidationException(HttpStatus.BAD_REQUEST, "confirmPassword", "As senhas não coincidem.");
            }
            user.setPassword(passwordEncoder.encode(dto.password()));
        }

        userMapper.updateEntityFromDto(dto, user);

        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE_NAME,
            "user.updated",
            new UserEvent(user.getName(), user.getEmail())
        );

        return userRepository.save(user);
    }

    public void sendCode(User user) {
        String code = codeGenerator.generateNumberCode();

        verificationCodeService.saveCode(user.getId(), code);
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.EXCHANGE_NAME,
            "user.verification-code",
            new VerificationCodeEvent(user.getName(), code, user.getEmail())
        );
    }
}

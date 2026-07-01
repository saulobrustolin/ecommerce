package saulo.brustolin.api.services;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import saulo.brustolin.api.dtos.auth.AuthenticationDTO;
import saulo.brustolin.api.dtos.auth.RegisterDTO;
import saulo.brustolin.api.repositories.UserRepository;
import saulo.brustolin.api.utils.CookieUtil;
import saulo.brustolin.api.exceptions.ErrorException;
import saulo.brustolin.api.exceptions.ValidationException;
import saulo.brustolin.api.entities.User;

@Service
@AllArgsConstructor
public class AuthenticationService {
    
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private final CookieUtil cookieUtil;

    public void authenticate(AuthenticationDTO dto, HttpServletResponse response) {
        var user = userRepository.findByEmailAndIsActiveTrue(dto.email())
            .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new ErrorException(HttpStatus.UNAUTHORIZED, "E-mail ou senha incorreta");
        }

        String token = tokenService.generateToken(user.getEmail());

        cookieUtil.addingCookie(response, token);
    }

    public void register(RegisterDTO dto, HttpServletResponse response) {
        if (userRepository.existsByEmail(dto.email())) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "email", "Já existe um usuário com este e-mail");
        }
        if (userRepository.existsByCpf(dto.cpf())) {
            throw new ValidationException(HttpStatus.BAD_REQUEST, "cpf", "Já existe um usuário com este CPF");
        }

        if (!dto.password().equals(dto.confirmPassword())) {
            throw new ErrorException(HttpStatus.BAD_REQUEST, "As senhas não são iguais");
        }

        var user = new User(dto.name(), dto.email(), dto.cpf(), passwordEncoder.encode(dto.password()), new HashSet<>(), null);
        userRepository.save(user);

        String token = tokenService.generateToken(user.getEmail());
        cookieUtil.addingCookie(response, token);
    }

    public void logout(HttpServletResponse response) {
        try {
            cookieUtil.removeCookie(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package saulo.brustolin.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import saulo.brustolin.api.entities.VerificationCode;

@Repository
public interface VerificationCodeRepository extends MongoRepository<VerificationCode, String> {
    Optional<VerificationCode> findByIdAndCode(String userId, String code);
}

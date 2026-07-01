package saulo.brustolin.api.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import saulo.brustolin.api.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmailAndIsActiveTrue(String email);
    UserDetails findByIdAndIsActiveTrue(String id);
    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}

package saulo.brustolin.api.services;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import saulo.brustolin.api.entities.User;
import saulo.brustolin.api.repositories.UserRepository;

@Service
@AllArgsConstructor
public class FavoriteService {

    private final UserRepository userRepository;
    
    public void addFavoriteProduct(User user, String productId) {
        user.addingFavorite(productId);

        userRepository.save(user);
    }

    public void removeFavoriteProduct(User user, String productId) {
        user.removeFavorite(productId);

        userRepository.save(user);
    }
}

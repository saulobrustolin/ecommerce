package saulo.brustolin.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import saulo.brustolin.api.entities.User;
import saulo.brustolin.api.services.FavoriteService;

@RestController
@RequestMapping(path = "favorites")
@AllArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;
    
    @PostMapping(path = "/{productId}")
    public ResponseEntity<Void> create(
        @AuthenticationPrincipal User user,
        @PathVariable String productId
    ) {
        favoriteService.addFavoriteProduct(user, productId);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{productId}")
    public ResponseEntity<Void> delete(
        @AuthenticationPrincipal User user,
        @PathVariable String productId
    ) {
        favoriteService.removeFavoriteProduct(user, productId);

        return ResponseEntity.noContent().build();
    }
}

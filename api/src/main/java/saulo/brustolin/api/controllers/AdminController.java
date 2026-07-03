package saulo.brustolin.api.controllers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import saulo.brustolin.api.dtos.admin.AdminCreateProductDTO;
import saulo.brustolin.shared.entities.Product;
import saulo.brustolin.shared.repositories.ProductRepository;

@RestController
@RequestMapping(path = "admin")
@AllArgsConstructor
public class AdminController {
    
    private final ProductRepository productRepository;

    @PostMapping(value = "products", consumes = "multipart/form-data", produces = "application/json")
    private void createProduct(
        @ModelAttribute @Valid AdminCreateProductDTO dto
    ) {
        Product product = new Product(null, null, null, null, null);

        productRepository.save(product);
    }
}

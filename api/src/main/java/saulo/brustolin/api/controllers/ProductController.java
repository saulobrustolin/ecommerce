package saulo.brustolin.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import saulo.brustolin.shared.dtos.products.ProductCatalogDTO;
import saulo.brustolin.api.services.ProductService;

@RestController
@RequestMapping(path = "products")
@AllArgsConstructor
public class ProductController {
    
    private final ProductService productService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<Page<ProductCatalogDTO>> productsCatalog(
        @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable
    ) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }
}

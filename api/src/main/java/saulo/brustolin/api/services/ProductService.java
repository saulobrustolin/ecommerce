package saulo.brustolin.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import saulo.brustolin.shared.dtos.products.ProductCatalogDTO;
import saulo.brustolin.shared.repositories.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductCatalogDTO> findAll(Pageable pageable) {
        return productRepository.findAllToCatalog(pageable);
    }
}

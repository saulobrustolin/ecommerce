package saulo.brustolin.api.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import saulo.brustolin.api.dtos.products.ProductDTO;
import saulo.brustolin.api.exceptions.ErrorException;
import saulo.brustolin.shared.dtos.products.ProductCatalogDTO;
import saulo.brustolin.shared.entities.Product;
import saulo.brustolin.shared.entities.Sku;
import saulo.brustolin.shared.repositories.ProductRepository;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Page<ProductCatalogDTO> findAll(Pageable pageable) {
        return productRepository.findAllToCatalog(pageable);
    }

    public ProductDTO get(String productId) {
        Product product = productRepository.findByIdAndIsActiveTrue(productId)
            .orElseThrow(() -> new ErrorException(HttpStatus.NOT_FOUND, "Nenhum produto foi encontrado."));

        Sku firstSku = product.getSkus().stream().findFirst()
            .orElseThrow(() -> new ErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno."));

        return new ProductDTO(
            productId,
            product.getTitle(),
            product.getDescription(),
            firstSku.getPrice(),
            firstSku.getLatestPrice(),
            product.getAverageRating(),
            product.getFeaturedPhotos(),
            product.getSkus()
        );
    }
}

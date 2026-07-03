package saulo.brustolin.shared.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import saulo.brustolin.shared.dtos.products.ProductCatalogDTO;
import saulo.brustolin.shared.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    Page<ProductCatalogDTO> findAllToCatalog(Pageable pageable);
    Optional<Product> findByIdAndIsActiveTrue(String productId);
}

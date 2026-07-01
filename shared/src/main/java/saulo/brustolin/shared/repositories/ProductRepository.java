package saulo.brustolin.shared.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import saulo.brustolin.shared.dtos.products.ProductCatalogDTO;
import saulo.brustolin.shared.dtos.products.ProductSkuPrice;
import saulo.brustolin.shared.entities.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    @Query(value = "{ '_id': ?0, 'skus.sku': ?1 }", fields = "{ 'skus.$': 1 }")
    Optional<ProductSkuPrice> findPriceBySkuId(String productId, String skuId);

    Page<ProductCatalogDTO> findAllToCatalog(Pageable pageable);
}

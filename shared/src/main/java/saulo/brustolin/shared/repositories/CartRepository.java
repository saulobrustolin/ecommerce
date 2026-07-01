package saulo.brustolin.shared.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;

import saulo.brustolin.shared.entities.Cart;

@Repository
public interface CartRepository extends MongoRepository<Cart, String> {

    @Query("{ 'items.productId': ?0, 'items.skuId': ?1 }")
    @Update("{ '$set': { 'items.$.price': ?2 } }")
    void updateProductPriceInAllCarts(String productId, String skuId, Integer price);
}
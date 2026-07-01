package saulo.brustolin.shared.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import saulo.brustolin.shared.entities.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    @Query(value = "{ 'productId': ?0 }", fields = "{ 'rating': 1, '_id': 0 }")
    List<Double> findRatingsByProductId(String productId);
}

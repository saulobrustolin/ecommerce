package saulo.brustolin.shared.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import saulo.brustolin.shared.repositories.ReviewRepository;

@Service
@AllArgsConstructor
public class ReviewService {
    
    private final ReviewRepository reviewRepository;

    public Double ratingProduct(String productId) {
        List<Double> ratings = reviewRepository.findRatingsByProductId(productId);
        
        return calculateRating(ratings);
    }

    private Double calculateRating(List<Double> ratings) {
        if (ratings == null || ratings.isEmpty()) {
            return 0.0;
        }

        double average = ratings.stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
        
        return BigDecimal.valueOf(average)
            .setScale(2, RoundingMode.HALF_UP)
            .doubleValue();
    }
}

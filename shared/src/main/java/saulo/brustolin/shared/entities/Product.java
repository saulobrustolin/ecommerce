package saulo.brustolin.shared.entities;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.github.f4b6a3.ulid.UlidCreator;
import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Document(collection = "Products")
@RequiredArgsConstructor
public class Product {
    
    @Id
    private String id = "product_" + UlidCreator.getMonotonicUlid().toString().toLowerCase();;

    @NonNull private String title;
    @NonNull private String description;
    @NonNull private String category;
    @NonNull private Set<Sku> skus;
    @NonNull private Set<String> tags;

    private Set<Color> colors;
    private Double averageRating = null;
    private Set<String> featuredPhotos = new HashSet<>();
    private Integer price = null;

    private Boolean isActive = true;
    
    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}

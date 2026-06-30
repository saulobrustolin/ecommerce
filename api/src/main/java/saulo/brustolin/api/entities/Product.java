package saulo.brustolin.api.entities;

import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Document(collection = "Products")
@RequiredArgsConstructor
public class Product {
    
    @Id
    private String id;

    @NonNull private String name;
    @NonNull private String description;
    @NonNull private String category;
    @NonNull private Set<SkuProduct> skus;
    @NonNull private Set<String> tags;
    @NonNull private Set<String> featuredImages;

    private Boolean isActive = true;
    
    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}

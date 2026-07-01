package saulo.brustolin.api.entities;

import java.time.Instant;
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
@Document(collection = "Categories")
@RequiredArgsConstructor
public class Category {
    
    @Id
    private String id = "category_" + UlidCreator.getMonotonicUlid().toString().toLowerCase();

    @NonNull private String name;
    @NonNull private Set<ProductFragmentCollection> products;
    
    private Boolean isActive = true;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}

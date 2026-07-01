package saulo.brustolin.shared.entities;

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
@Document(collection = "Reviews")
@RequiredArgsConstructor
public class Review {
    
    @Id
    private String id = "review_" + UlidCreator.getMonotonicUlid().toString().toLowerCase();;

    @NonNull private String user;
    @NonNull private Double rating;
    @NonNull private String title;
    @NonNull private String description;

    @NonNull private Set<String> images;

    @NonNull private String orderId;

    private Boolean isActive = true;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}

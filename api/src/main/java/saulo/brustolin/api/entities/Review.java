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
@Document(collection = "Reviews")
@RequiredArgsConstructor
public class Review {
    
    @Id
    private String id;

    @NonNull private String user;
    @NonNull private Double rating;
    @NonNull private String title;
    @NonNull private String description;

    @NonNull private Set<String> images;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}

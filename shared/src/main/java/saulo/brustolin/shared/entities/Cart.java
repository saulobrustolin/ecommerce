package saulo.brustolin.shared.entities;

import java.time.Instant;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.github.f4b6a3.ulid.UlidCreator;

import lombok.Data;

@Data
@Document(collection = "Carts")
public class Cart {

    @Id
    private String id = "cart_" + UlidCreator.getMonotonicUlid().toString().toLowerCase();
 
    private String userId;
    private StatusCart status;
    private Set<CartItem> items;

    @LastModifiedDate
    private Instant updatedAt;
}

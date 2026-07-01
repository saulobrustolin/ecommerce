package saulo.brustolin.api.entities;

import java.time.Instant;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.github.f4b6a3.ulid.UlidCreator;
import com.mongodb.lang.NonNull;

import lombok.Data;

@Data
@Document(collection = "Orders")
public class Order {

    @Id
    private String id = "order_" + UlidCreator.getMonotonicUlid().toString().toLowerCase();;

    @NonNull private String order;
    
    @NonNull private List<OrderItem> items;
    @NonNull private Status status = Status.CREATED;
    @NonNull private Integer totalAmount;
    @NonNull private String userId;

    private Address shipping_address;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;
}

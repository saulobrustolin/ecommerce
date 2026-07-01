package saulo.brustolin.shared.entities;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Data
public class CartItem {
    private String productId;
    private String skuId;
    private String name;
    private Integer price;
    private Integer quantity;
    
    @CreatedDate
    private Instant addedAt;
}

package saulo.brustolin.api.entities;

import lombok.Data;

@Data
public class ProductFragmentCollection {
    
    private String productId;

    private String name;
    private Integer price;
    private Double rating;
    private String featuredPhoto;
}

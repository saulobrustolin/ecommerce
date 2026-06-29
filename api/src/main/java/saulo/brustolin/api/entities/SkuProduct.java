package saulo.brustolin.api.entities;

import java.util.Set;
import java.util.UUID;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SkuProduct {
    
    private String sku = UUID.randomUUID().toString();
    @NonNull private Integer price;
    @NonNull private Integer latest_price;
    @NonNull private Integer inventory;
    @NonNull private SkuAttribute attributes;
    @NonNull private Set<String> images;
}

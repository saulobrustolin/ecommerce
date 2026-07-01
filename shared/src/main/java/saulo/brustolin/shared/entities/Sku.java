package saulo.brustolin.shared.entities;

import java.util.Set;

import com.github.f4b6a3.ulid.UlidCreator;
import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Sku {
    
    private String id = "sku_" + UlidCreator.getMonotonicUlid().toString().toLowerCase();
    @NonNull private Integer price;
    @NonNull private Integer latestPrice;
    @NonNull private Integer inventory;
    @NonNull private SkuAttribute attributes;
    @NonNull private Set<String> images;
}

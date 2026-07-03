package saulo.brustolin.api.dtos.products;

import java.util.Set;

import saulo.brustolin.shared.entities.Sku;

public record ProductDTO(
    String productId,
    String title,
    String description,
    Integer price,
    Integer latestPrice,
    Double rating,
    Set<String> featuresPhotos,
    Set<Sku> skus
) {}

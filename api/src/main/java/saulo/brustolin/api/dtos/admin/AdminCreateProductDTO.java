package saulo.brustolin.api.dtos.admin;

import java.util.List;

import saulo.brustolin.api.dtos.sku.CreateSkuDTO;

public record AdminCreateProductDTO(
    String title,
    String description,
    List<String> featuresPhotos,
    List<CreateSkuDTO> skus
) {}

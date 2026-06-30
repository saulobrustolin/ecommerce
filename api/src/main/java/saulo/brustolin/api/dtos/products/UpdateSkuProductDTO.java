package saulo.brustolin.api.dtos.products;

import jakarta.validation.constraints.PositiveOrZero;
import saulo.brustolin.api.entities.SkuAttribute;

public record UpdateSkuProductDTO(
    @PositiveOrZero(message = "O preço precisa ser maior ou igual a zero") Integer price,
    @PositiveOrZero(message = "O preço de ancoragem precisa ser maior ou igual a zero") Integer latestPrice,
    @PositiveOrZero(message = "O inventário precisa ser maior ou igual a zero") Integer inventory,
    SkuAttribute attributes
) {}

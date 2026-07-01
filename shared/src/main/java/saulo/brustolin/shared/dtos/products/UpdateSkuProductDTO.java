package saulo.brustolin.shared.dtos.products;

import jakarta.validation.constraints.PositiveOrZero;
import saulo.brustolin.shared.entities.SkuAttribute;

public record UpdateSkuProductDTO(
    @PositiveOrZero(message = "O preço precisa ser maior ou igual a zero") Integer price,
    @PositiveOrZero(message = "O preço de ancoragem precisa ser maior ou igual a zero") Integer latestPrice,
    @PositiveOrZero(message = "O inventário precisa ser maior ou igual a zero") Integer inventory,
    SkuAttribute attributes
) {}

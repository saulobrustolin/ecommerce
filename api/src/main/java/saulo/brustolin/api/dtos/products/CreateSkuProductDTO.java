package saulo.brustolin.api.dtos.products;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import saulo.brustolin.api.entities.SkuAttribute;

public record CreateSkuProductDTO(
    @NotNull @PositiveOrZero(message = "O preço precisa ser positivo ou zero") Integer price,
    @NotNull @PositiveOrZero(message = "O preço de ancoragem precisa ser positivo ou zero") Integer latestPrice,
    @NotNull @PositiveOrZero(message = "A quantidade precisa ser positivo ou zero") Integer inventory,
    SkuAttribute attributes
) {}

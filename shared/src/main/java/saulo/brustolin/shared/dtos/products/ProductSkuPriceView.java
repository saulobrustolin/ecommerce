package saulo.brustolin.shared.dtos.products;

import jakarta.validation.constraints.NotNull;

public record ProductSkuPriceView(
    @NotNull Integer price
) {}

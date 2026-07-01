package saulo.brustolin.shared.dtos.transfer;

import jakarta.validation.constraints.NotEmpty;

public record ChangePriceDTO(
    @NotEmpty String productId,
    @NotEmpty String skuId
) {}

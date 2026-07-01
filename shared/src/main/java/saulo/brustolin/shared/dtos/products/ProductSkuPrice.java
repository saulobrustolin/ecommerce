package saulo.brustolin.shared.dtos.products;

import java.util.List;

public record ProductSkuPrice(
    List<ProductSkuPriceView> skus
) {}
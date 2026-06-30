package saulo.brustolin.api.entities;

public record OrderItem(
    String productId,
    String name,
    String variantName,
    String imageBasePath, 
    String sku,
    Integer priceAtPurchase,
    Integer quantity
) {}

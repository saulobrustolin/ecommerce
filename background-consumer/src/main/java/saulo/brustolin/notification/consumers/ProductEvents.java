package saulo.brustolin.notification.consumers;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import saulo.brustolin.notification.configurations.RabbitMQConfig;
import saulo.brustolin.shared.exceptions.NotFoundException;
import saulo.brustolin.shared.repositories.CartRepository;
import saulo.brustolin.shared.repositories.ProductRepository;
import saulo.brustolin.shared.dtos.transfer.ChangePriceDTO;

@Component
@AllArgsConstructor
public class ProductEvents {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    
    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "notifications.v1.products", durable = "true"),
        exchange = @Exchange(value = RabbitMQConfig.EXCHANGE_NAME, type = "direct"),
        key = "product.update-price"
    ))
    public void priceChange(ChangePriceDTO dto) {
        Integer price = productRepository.findPriceBySkuId(dto.productId(), dto.skuId())
            .stream()
            .flatMap(s -> s.skus().stream())
            .map(sku -> sku.price())
            .findFirst()
            .orElseThrow(() -> new NotFoundException(String.format("Preço para o SKU '%s' não encontrado.", dto.skuId())));

        cartRepository.updateProductPriceInAllCarts(dto.productId(), dto.skuId(), price);
    }
}

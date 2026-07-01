package saulo.brustolin.notification.consumers;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import saulo.brustolin.notification.configurations.RabbitMQConfig;

@Component
@AllArgsConstructor
public class ProductEvents {
    
    @RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "notifications.v1.products", durable = "true"),
        exchange = @Exchange(value = RabbitMQConfig.EXCHANGE_NAME, type = "direct"),
        key = "product.update-price"
    ))
    public void priceChange(String dto) {
 
    }
}

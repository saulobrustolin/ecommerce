package saulo.brustolin.api.dtos.sku;

import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import saulo.brustolin.shared.entities.SkuAttribute;

public record CreateSkuDTO(
    @NotNull @PositiveOrZero(message = "O preço precisa ser maior ou igual a zero") Integer price,
    @NotNull @PositiveOrZero(message = "O preço de ancoragem precisa ser maior ou igual a zero") Integer latestPrice,
    @NotNull @PositiveOrZero(message = "O estoque precisa ser maior ou igual a zero") Integer inventory,
    @NotNull SkuAttribute attribute,
    Set<MultipartFile> images
) {}

package saulo.brustolin.shared.dtos.products;

import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Field;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import saulo.brustolin.shared.entities.Color;

public record ProductCatalogDTO(
    @Field("id")
    @NotEmpty(message = "O ID do produto é obrigatório")
    String productId,
    @NotEmpty(message = "O título do produto é obrigatório") String title,
    @NotNull(message = "O preço do produto é obrigatório")
    @PositiveOrZero(message = "O preço precisa ser maior ou igual a zero")
    Integer price,
    @PositiveOrZero(message = "A avaliação precisa ser maior ou igual a zero")
    @Max(5)
    Double averageRating,
    Set<Color> colors,
    @NotEmpty(message = "A foto principal é obrigatória") Set<String> featuredPhotos
) {}

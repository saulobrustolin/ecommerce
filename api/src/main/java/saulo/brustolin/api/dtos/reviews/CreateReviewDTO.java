package saulo.brustolin.api.dtos.reviews;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateReviewDTO(
    @PositiveOrZero(message = "A avaliação precisa ser maior ou igual a zero") @Max(5) Double rating,
    @NotNull(message = "O título da avaliação é obrigatório") String title,
    @Size(min = 1, message = "A descrição não pode ser vazia") String description
) {}

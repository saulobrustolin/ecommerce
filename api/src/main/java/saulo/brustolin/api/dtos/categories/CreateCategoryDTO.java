package saulo.brustolin.api.dtos.categories;

import jakarta.validation.constraints.NotEmpty;

public record CreateCategoryDTO(
    @NotEmpty(message = "O nome da categoria é obrigatório") String name
) {}

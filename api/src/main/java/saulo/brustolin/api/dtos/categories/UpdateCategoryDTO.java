package saulo.brustolin.api.dtos.categories;

import jakarta.validation.constraints.Size;

public record UpdateCategoryDTO(
    @Size(min = 1, message = "O nome é obrigatório") String name,
    Boolean isActive
) {}

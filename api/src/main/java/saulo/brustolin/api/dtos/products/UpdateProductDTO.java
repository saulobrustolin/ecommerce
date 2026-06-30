package saulo.brustolin.api.dtos.products;

import java.util.Set;

import jakarta.validation.constraints.Size;
import saulo.brustolin.api.entities.Status;

public record UpdateProductDTO(
    @Size(min = 8, message = "O nome precisa ter no mínimo 8 caracteres") String name,
    @Size(min = 1, message = "A descrição não pode ser vazia") String description,
    @Size(min = 1, message = "A categoria não pode ser vazia") String category,
    Set<String> tags,
    Status status
) {}

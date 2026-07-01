package saulo.brustolin.shared.dtos.products;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import saulo.brustolin.shared.entities.Sku;

public record CreateProductDTO(
    @NotEmpty(message = "O nome é obrigatório")
    @Size(min = 8, message = "O nome do produto precisa ter no mínimo 8 caracteres")
    String name,
    @NotEmpty(message = "A descrição do produto é obrigatória")
    String description,
    @NotEmpty(message = "A categoria do produto é obrigatória")
    String category,
    Set<Sku> skus
) {}

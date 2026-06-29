package saulo.brustolin.api.dtos.users;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record RegisterAddressDTO(
    Boolean defaultAddress,
    String street,
    @NotEmpty(message = "O número é obrigatório")
    @Size(min = 1, message = "O número não pode ser vazio")
    String number,
    @NotEmpty(message = "O bairro é obrigatório")
    @Size(min = 1, message = "O bairro não pode ser vazio")
    String neighborhood,
    @NotEmpty(message = "A cidade é obrigatória")
    @Size(min = 1, message = "A cidade precisa ser válida")
    String city,
    @NotEmpty(message = "O estado é obrigatório")
    @Size(min = 2, message = "O estado precisa ser válido")
    @Pattern(regexp = "^[A-Z]{2}$", message = "O estado deve conter exatamente 2 letras")
    String uf,
    @NotEmpty(message = "O CEP é obrigatório")
    @Size(min = 8, message = "O CEP precisa ser válido")
    String cep,
    @Size(min = 1, message = "A observação não pode ser vazia")
    String obs
) {}

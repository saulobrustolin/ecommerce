package saulo.brustolin.api.dtos.exceptions;

public record ValidationErrorDTO(
    String field,
    String message
) {}

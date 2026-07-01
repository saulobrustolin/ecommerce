package saulo.brustolin.shared.dtos.events;

public record VerificationCodeEvent(
    String fullName,
    String code,
    String email
) {}

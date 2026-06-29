package saulo.brustolin.api.dtos.users;

public record ResumeUserDTO(
    Integer current_balance,
    Integer net_balance,
    Integer credit,
    Integer debit
) {}
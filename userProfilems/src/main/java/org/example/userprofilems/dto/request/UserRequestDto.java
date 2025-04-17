package org.example.userprofilems.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserRequestDto(
        @NotBlank(message = "username cannot be blank/empty/null")
        String username,
        @NotBlank(message = "password cannot be blank/empty/null")
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[?*+!])[A-Za-z0-9?*+!]{4,8}$")
        String password,
        @NotNull(message = "Profile cannot be null")
        @Valid
        ProfileRequestDto profileRequestDto
) {
}

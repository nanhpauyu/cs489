package org.example.cs489finalexam.dto.request;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public record AstronautRequestDto(
        @NotBlank(message = "Firstname cannot be blank")
        String firstName,
        @NotBlank(message = "Lastname cannot be blank")
        String lastName,
        @Range(min = 0, max = 50, message = "Years of Experience should be between 0 and 50")
        Integer experienceYears,
        Long satelliteId
) {
}

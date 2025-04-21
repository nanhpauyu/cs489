package org.example.cs489finalexam.dto.response;

public record AstronautResponseDto(
        Long astronaut_id,
        String firstName,
        String lastName,
        Integer experienceYears
) {
}

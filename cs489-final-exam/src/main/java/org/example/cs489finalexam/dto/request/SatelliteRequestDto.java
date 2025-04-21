package org.example.cs489finalexam.dto.request;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import org.example.cs489finalexam.model.OrbitType;

import java.time.LocalDate;

public record SatelliteRequestDto(
        String name,
        @Past(message = "LaunchDate must not be todat or future")
        LocalDate launchDate,
        @Pattern(regexp = "^(LEO|MEO|GEO)$", message = "Orbit type must be LEO, MEO, GEO. No Space, all Cap")
        String orbitType,
        Boolean decommissioned
) {
}

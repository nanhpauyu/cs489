package org.example.cs489finalexam.dto.response;

import org.example.cs489finalexam.model.OrbitType;

import java.time.LocalDate;

public record SatelliteResponseDto(
        Long satelliteId,
        String name,
        LocalDate launchDate,
        String orbitType,
        Boolean decommissioned
) {
}

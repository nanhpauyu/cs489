package org.example.dentalservice.dto.request;

import org.example.dentalservice.model.Address;

public record PatientRequestDto(
        String name,
        AddressRequestDto addressRequestDto
) {
}

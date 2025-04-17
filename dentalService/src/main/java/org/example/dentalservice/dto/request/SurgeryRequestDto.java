package org.example.dentalservice.dto.request;

public record SurgeryRequestDto(
        String name,
        AddressRequestDto  addressRequestDto
) {
}

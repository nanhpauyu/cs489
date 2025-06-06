package org.example.dentalservice.dto.response;

import org.example.dentalservice.dto.request.AddressRequestDto;

public record SurgeryResponseDto(
        Long id,
        String name,
        AddressResponseDto addressResponseDto
) {
}

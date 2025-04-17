package org.example.dentalservice.dto.response;

import org.example.dentalservice.model.Patient;

public record AddressResponseDto(
        Long id,
        String street,
        String city,
        String state,
        String zip
) {
}

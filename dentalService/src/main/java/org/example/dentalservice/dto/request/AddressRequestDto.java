package org.example.dentalservice.dto.request;

public record AddressRequestDto(
        String street,
        String city,
        String state,
        String zip
) {
}

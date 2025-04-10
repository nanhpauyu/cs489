package com.libms.libms.dto.response;

public record PublisherResponseDto(
        Long id,
        String name,
        AddressResponseDto addressResponseDto
) {
}

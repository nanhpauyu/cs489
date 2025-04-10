package com.libms.libms.dto.request;

public record PublisherRequestDto(
        String name,
        AddressRequestDto addressRequestDto
) {
}

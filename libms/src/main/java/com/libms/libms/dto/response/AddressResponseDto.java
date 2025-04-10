package com.libms.libms.dto.response;

public record AddressResponseDto(
        Long id,
        String unitNo,
        String street,
        String city,
        String state,
        String zip
) {
}

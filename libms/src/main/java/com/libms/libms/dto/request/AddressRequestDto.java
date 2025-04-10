package com.libms.libms.dto.request;

public record AddressRequestDto(
        String unitNo,
        String street,
        String city,
        String state,
        String zip
) {
}

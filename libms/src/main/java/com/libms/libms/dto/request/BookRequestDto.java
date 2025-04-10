package com.libms.libms.dto.request;

import java.util.List;

public record BookRequestDto(
        String title,
        String isbn,
        List<AuthorRequestDto> authorRequestDtos,
        PublisherRequestDto publisherRequestDto
) {
}

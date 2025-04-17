package org.example.userprofilems.dto.response;

public record UserResponseDto(
        String username,
        ProfileResponseDto profileResponseDto
) {
}

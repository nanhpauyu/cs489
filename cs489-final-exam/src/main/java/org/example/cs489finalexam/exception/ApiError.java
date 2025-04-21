package org.example.cs489finalexam.exception;

import java.time.Instant;

public record ApiError(
        Instant timeStamp,
        Integer statusCode,
        String statusMessage,
        String message,
        String path
) {
}

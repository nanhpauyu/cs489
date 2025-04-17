package org.example.userprofilems.exception;

import java.time.Instant;

public record ApiError(
        Integer statusCode,
        String message,
        Instant timeStamp,
        String path
) {
}

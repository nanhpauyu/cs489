package org.example.userprofilems.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.example.userprofilems.exception.user.DuplicateUserException;
import org.example.userprofilems.exception.user.UserNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicateUserException.class)
    public ResponseEntity<ApiError> handleDuplicateUserException(DuplicateUserException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                Instant.now(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.CONFLICT.value(),
                e.getMessage(),
                Instant.now(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        String errorMessage = e.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(","));
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                errorMessage,
                Instant.now(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(UserNotFoundException e, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                Instant.now(),
                request.getRequestURI()

        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

}

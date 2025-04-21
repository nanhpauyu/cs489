package org.example.cs489finalexam.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.cs489finalexam.exception.customexception.SatelliteDecommissionedException;
import org.example.cs489finalexam.exception.customexception.SatelliteNameExistedException;
import org.example.cs489finalexam.exception.customexception.SatelliteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //    @ExceptionHandler(DuplicateUserException.class)
//    public ResponseEntity<ApiError> handleDuplicateUserException(DuplicateUserException e, HttpServletRequest request) {
//        ApiError apiError = new ApiError(
//                HttpStatus.BAD_REQUEST.value(),
//                e.getMessage(),
//                Instant.now(),
//                request.getRequestURI()
//        );
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
//    }
    @ExceptionHandler(SatelliteNameExistedException.class)
    public ResponseEntity<ApiError> handleSatelliteNameExistedException(SatelliteNameExistedException ex, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ApiError> handleSatelliteNotFoundException(SatelliteNotFoundException ex,HttpServletRequest request) {
        ApiError apiError = new ApiError(
                Instant.now(),
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.name(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
    @ExceptionHandler(SatelliteDecommissionedException.class)
    public ResponseEntity<ApiError> handleSatelliteDecommissionedException(SatelliteDecommissionedException ex,HttpServletRequest request) {
        ApiError apiError = new ApiError(
                Instant.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.name(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}

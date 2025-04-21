package org.example.cs489finalexam.exception.customexception;

public class AstronautNotFoundException extends RuntimeException {
    public AstronautNotFoundException(String message) {
        super(message);
    }
}

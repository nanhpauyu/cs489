package org.example.cs489finalexam.exception.customexception;

public class SatelliteNameExistedException extends RuntimeException {
    public SatelliteNameExistedException(String message) {
        super(message);
    }
}

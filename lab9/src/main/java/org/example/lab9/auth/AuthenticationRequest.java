package org.example.lab9.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}

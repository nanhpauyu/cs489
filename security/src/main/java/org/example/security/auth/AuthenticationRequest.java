package org.example.security.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}

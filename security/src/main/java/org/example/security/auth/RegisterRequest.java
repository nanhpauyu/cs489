package org.example.security.auth;

import org.example.security.user.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        Role role
) {
}

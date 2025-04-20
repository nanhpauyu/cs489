package org.example.lab9.auth;

import org.example.lab9.model.Role;

public record RegisterRequest(
        String username,
        String password,
        Role role
) {
}

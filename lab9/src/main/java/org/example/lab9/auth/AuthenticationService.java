package org.example.lab9.auth;


import lombok.RequiredArgsConstructor;

import org.example.lab9.config.JwtService;
import org.example.lab9.model.User;
import org.example.lab9.repository.UserRepository;

import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = new User(
                registerRequest.username(),
                registerRequest.password(),
                registerRequest.role()
        );
        User registerUser = userRepository.save(user);
        String token = jwtService.generateToken(registerUser);
        return new AuthenticationResponse(token);
    }

}

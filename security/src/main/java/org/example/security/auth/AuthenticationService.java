package org.example.security.auth;


import lombok.RequiredArgsConstructor;
import org.example.security.config.JwtService;
import org.example.security.user.User;
import org.example.security.user.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

//    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
//        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//                authenticationRequest.username(), authenticationRequest.password()
//        );
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authenticationRequest.username(),
//                        passwordEncoder.encode(authenticationRequest.password())
//                )
//        );
//        var user = (User) authentication.getPrincipal();
//        String token = jwtService.generateToken(user);
//        System.out.println(token);

    /// /        return AuthenticationResponse.builder().tokern(token).build();
//        return new AuthenticationResponse(token);
//    }
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.username(),
                        authenticationRequest.password()
                )
        );
        //generate token for the user
        var user = (User) authentication.getPrincipal();
        String token = jwtService.generateToken(user);


//        return AuthenticationResponse
//                .builder()
//                .token(token)
//                .build();
        return new AuthenticationResponse(token);
    }

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = new User(
                registerRequest.firstName(),
                registerRequest.lastName(),
                registerRequest.username(),
                passwordEncoder.encode(registerRequest.password()),
                registerRequest.role()
        );
        User registeredUser = userRepository.save(user);
        String token = jwtService.generateToken(registeredUser);
        return new AuthenticationResponse(token);
    }
}

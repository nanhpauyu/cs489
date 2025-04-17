package org.example.security.auth;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(
            @RequestBody RegisterRequest registerRequest) {
        AuthenticationResponse authenticationResponse = authenticationService.register(registerRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(authenticationResponse);
    }

    @GetMapping("/authenticate")
    public String authenticate() {
        return "Authenticated";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(
                authenticationService.authenticate(request)
        );
    }

}

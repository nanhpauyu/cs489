package org.example.userprofilems.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.userprofilems.dto.request.UserRequestDto;
import org.example.userprofilems.dto.response.UserResponseDto;
import org.example.userprofilems.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getUsers() {
        List<UserResponseDto> userResponseDtos = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDtos);
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable String username, @Valid @RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(username, userRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

package org.example.lab9.service;

import org.example.lab9.dto.request.UserRequestDto;
import org.example.lab9.dto.response.UserResponseDto;
import org.example.lab9.model.User;

public interface UserService {

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updatePasswordByUsername(UserRequestDto userRequestDto);

    UserResponseDto deleteUserByUsername(String username);
}

package org.example.userprofilems.service;

import org.example.userprofilems.dto.request.UserRequestDto;
import org.example.userprofilems.dto.response.UserResponseDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserService {
    UserResponseDto createUser(UserRequestDto userRequestDto);
    UserResponseDto updateUser(String username,UserRequestDto userRequestDto);
    void deleteUserByUsername(String username);
    Optional<UserResponseDto> findUserByUsername(String username);
    List<UserResponseDto> findAllUsers();
}

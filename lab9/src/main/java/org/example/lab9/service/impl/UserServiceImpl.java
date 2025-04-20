package org.example.lab9.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.lab9.dto.request.UserRequestDto;
import org.example.lab9.dto.response.UserResponseDto;
import org.example.lab9.mapper.UserMapper;
import org.example.lab9.repository.UserRepository;
import org.example.lab9.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto updatePasswordByUsername(UserRequestDto userRequestDto) {
        return null;
    }

    @Override
    public UserResponseDto deleteUserByUsername(String username) {
        return null;
    }
}

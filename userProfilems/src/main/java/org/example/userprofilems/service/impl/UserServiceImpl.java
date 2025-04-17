package org.example.userprofilems.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.userprofilems.dto.request.UserRequestDto;
import org.example.userprofilems.dto.response.UserResponseDto;
import org.example.userprofilems.exception.user.DuplicateUserException;
import org.example.userprofilems.exception.user.UserNotFoundException;
import org.example.userprofilems.mapper.UserMapper;
import org.example.userprofilems.model.User;
import org.example.userprofilems.repository.UserRepository;
import org.example.userprofilems.service.UserService;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userRequestDto.username());
        if (optionalUser.isPresent()) {
            throw new DuplicateUserException("Username already exists");
        }
        User user = userMapper.userRequestDtoToUser(userRequestDto);
        User savedUser = userRepository.save(user);
        return userMapper.userToUserResponseDto(savedUser);
    }

    @Override
    public UserResponseDto updateUser(String username, UserRequestDto userRequestDto) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            User mappedUser = userMapper.userRequestDtoToUser(userRequestDto);
            mappedUser.setId(existingUser.getId());
            if (mappedUser.getProfile() != null) {
                mappedUser.getProfile().setId(existingUser.getProfile().getId());
            }
            User updatedUser = userRepository.save(mappedUser);
            return userMapper.userToUserResponseDto(updatedUser);
        }
        throw new UserNotFoundException(username + " is not found");
    }

    @Override
    @Transactional
    public void deleteUserByUsername(String username) {
//        userRepository.findByUsername(username).ifPresent(user -> {userRepository.delete(user);});
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            userRepository.delete(optionalUser.get());
            return;
        }
        throw new UserNotFoundException(username + " is not found");
    }

    @Override
    public Optional<UserResponseDto> findUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public List<UserResponseDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.usersToUserResponseDtoList(users);
    }
}

package org.example.lab9.mapper;

import org.example.lab9.dto.request.UserRequestDto;
import org.example.lab9.dto.response.UserResponseDto;
import org.example.lab9.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    User userRequetDtoToUser(UserRequestDto userRequestDto);

    UserResponseDto userToUserResponseDto(User user);
}

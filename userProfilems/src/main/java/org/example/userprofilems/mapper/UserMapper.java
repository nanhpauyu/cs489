package org.example.userprofilems.mapper;


import org.example.userprofilems.dto.request.UserRequestDto;
import org.example.userprofilems.dto.response.UserResponseDto;
import org.example.userprofilems.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "profileRequestDto", target = "profile")
    User userRequestDtoToUser(UserRequestDto userRequestDto);

    @Mapping(source = "profile", target = "profileResponseDto")
    UserResponseDto userToUserResponseDto(User user);

    @Mapping(source = "profile", target = "profileResponseDto")
    List<UserResponseDto> usersToUserResponseDtoList(List<User> users);

}

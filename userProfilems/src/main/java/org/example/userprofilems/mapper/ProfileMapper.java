package org.example.userprofilems.mapper;

import org.example.userprofilems.dto.request.UserRequestDto;
import org.example.userprofilems.dto.response.ProfileResponseDto;
import org.example.userprofilems.model.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    Profile profileRequestDtoToProfile(UserRequestDto userRequestDto);

    ProfileResponseDto profileToProfileResponseDto(Profile profile);
}

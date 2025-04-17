package org.example.dentalservice.mapper;

import org.example.dentalservice.dto.request.SurgeryRequestDto;
import org.example.dentalservice.dto.response.SurgeryResponseDto;
import org.example.dentalservice.model.Surgery;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SurgeryMapper {
    @Mapping(source = "addressRequestDto", target = "address")
    Surgery surgeryRequestDtoToSurgery(SurgeryRequestDto surgeryRequestDto);


    @Mapping(source = "address", target = "addressResponseDto")
    SurgeryResponseDto surgeryToSurveyResponseDto(Surgery surgery);
}

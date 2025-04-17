package org.example.dentalservice.mapper;

import org.example.dentalservice.dto.request.DentistRequestDto;
import org.example.dentalservice.dto.response.DentistResponseDto;
import org.example.dentalservice.model.Dentist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface DentistMapper {
    Dentist dentistRequestDtoToDentist(DentistRequestDto dentistRequestDto);

    DentistResponseDto dentistToDentistResponseDto(Dentist dentist);
}

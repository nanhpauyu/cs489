package org.example.cs489finalexam.mapper;

import org.example.cs489finalexam.dto.request.AstronautRequestDto;
import org.example.cs489finalexam.dto.request.SatelliteRequestDto;
import org.example.cs489finalexam.dto.response.AstronautResponseDto;
import org.example.cs489finalexam.dto.response.SatelliteResponseDto;
import org.example.cs489finalexam.model.Astronaut;
import org.example.cs489finalexam.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AstronautMapper {
    Astronaut astronautRequestDtoToAstronaut(AstronautRequestDto astronautRequestDto);

    AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);

    List<AstronautResponseDto> astronautsToAstronautResponseDtos(List<Astronaut> astronauts);
}

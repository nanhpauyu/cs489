package org.example.cs489finalexam.mapper;

import org.example.cs489finalexam.dto.request.SatelliteRequestDto;
import org.example.cs489finalexam.dto.response.SatelliteResponseDto;
import org.example.cs489finalexam.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SatelliteMapper {
    Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto satelliteRequestDto);

    SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);

    List<SatelliteResponseDto> satellitesToSatelliteResponseDtos(List<Satellite> satellites);
}

package org.example.cs489finalexam.service;

import org.example.cs489finalexam.dto.request.SatelliteRequestDto;
import org.example.cs489finalexam.dto.response.SatelliteResponseDto;

import java.util.List;

public interface SatelliteService {
    SatelliteResponseDto createSatellite(SatelliteRequestDto satelliteRequestDto);
    void deleteSatelliteById(Long id);
    SatelliteResponseDto updateSatelliteById(Long id,SatelliteRequestDto satelliteRequestDto);
    List<SatelliteResponseDto> getAllSatellites();

}

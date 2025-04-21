package org.example.cs489finalexam.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.cs489finalexam.dto.request.SatelliteRequestDto;
import org.example.cs489finalexam.dto.response.SatelliteResponseDto;
import org.example.cs489finalexam.exception.customexception.SatelliteDecommissionedException;
import org.example.cs489finalexam.exception.customexception.SatelliteNameExistedException;
import org.example.cs489finalexam.exception.customexception.SatelliteNotFoundException;
import org.example.cs489finalexam.mapper.SatelliteMapper;
import org.example.cs489finalexam.model.Satellite;
import org.example.cs489finalexam.repository.SatelliteRepository;
import org.example.cs489finalexam.service.SatelliteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;
    private final SatelliteMapper satelliteMapper;


    @Override
    public SatelliteResponseDto createSatellite(SatelliteRequestDto satelliteRequestDto) {
        Optional<Satellite> optionalSatellite = satelliteRepository.findByName(satelliteRequestDto.name());
        if (optionalSatellite.isPresent()) {
            throw new SatelliteNameExistedException(satelliteRequestDto.name() + " already exists");
        }
        Satellite satellite = satelliteMapper.satelliteRequestDtoToSatellite(satelliteRequestDto);
        satelliteRepository.save(satellite);
        return satelliteMapper.satelliteToSatelliteResponseDto(satellite);
    }

    @Override
    @Transactional
    public void deleteSatelliteById(Long id) {
        Optional<Satellite> optionalSatellite = satelliteRepository.findById(id);
        if (optionalSatellite.isPresent()) {
            Satellite satellite = optionalSatellite.get();
            satelliteRepository.delete(satellite);
            return;
        }
        throw new SatelliteNotFoundException("satellite with id " + id + " not found");
    }

    @Override
    public SatelliteResponseDto updateSatelliteById(Long id, SatelliteRequestDto satelliteRequestDto) {
        System.out.println(id);
        Optional<Satellite> optionalSatellite = satelliteRepository.findById(id);
        if (optionalSatellite.isPresent()) {
            Satellite satellite = optionalSatellite.get();
            if(satellite.getDecommissioned()){
                throw new SatelliteDecommissionedException("Satellite with id " + id + " has been decommissioned");
            }
            Satellite mappedSatellite = satelliteMapper.satelliteRequestDtoToSatellite(satelliteRequestDto);
            mappedSatellite.setSatelliteId(satellite.getSatelliteId());
            satelliteRepository.save(mappedSatellite);
            return satelliteMapper.satelliteToSatelliteResponseDto(mappedSatellite);
        }
        throw  new SatelliteNotFoundException("Satellite with id " + id + " not found");
    }

    @Override
    public List<SatelliteResponseDto> getAllSatellites() {
        List<Satellite> satellites = satelliteRepository.findAll();
        return satelliteMapper.satellitesToSatelliteResponseDtos(satellites);
    }

}

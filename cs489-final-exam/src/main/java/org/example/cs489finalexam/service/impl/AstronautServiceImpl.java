package org.example.cs489finalexam.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.cs489finalexam.dto.request.AstronautRequestDto;
import org.example.cs489finalexam.dto.response.AstronautResponseDto;
import org.example.cs489finalexam.exception.customexception.SatelliteNotFoundException;
import org.example.cs489finalexam.mapper.AstronautMapper;
import org.example.cs489finalexam.model.Astronaut;
import org.example.cs489finalexam.model.Satellite;
import org.example.cs489finalexam.repository.AstronautRepository;
import org.example.cs489finalexam.repository.SatelliteRepository;
import org.example.cs489finalexam.service.AstronautService;
import org.example.cs489finalexam.service.SatelliteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {
    private final AstronautRepository astronautRepository;
    private final AstronautMapper astronautMapper;
    private final SatelliteRepository satelliteRepository;


    @Override
    public AstronautResponseDto createAstronaut(AstronautRequestDto astronautRequestDto) {
        Long satelliteId = astronautRequestDto.satelliteId();
        Optional<Satellite> optionalSatellite = satelliteRepository.findById(satelliteId);
        if (optionalSatellite.isPresent()) {
            Satellite satellite = optionalSatellite.get();
            Astronaut astronaut = astronautMapper.astronautRequestDtoToAstronaut(astronautRequestDto);
            astronaut.getSatellites().add(satellite);
            satellite.getAstronauts().add(astronaut);
            astronautRepository.save(astronaut);
            return astronautMapper.astronautToAstronautResponseDto(astronaut);
        }
        throw  new SatelliteNotFoundException("Satellite not found");


    }

    @Override
    public Page<AstronautResponseDto> getAstronauts(Pageable pageable) {
        return astronautRepository.findAll(pageable)
                .map(astronautMapper::astronautToAstronautResponseDto);
    }
}

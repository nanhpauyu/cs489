package org.example.cs489finalexam.service;

import org.example.cs489finalexam.dto.request.AstronautRequestDto;
import org.example.cs489finalexam.dto.response.AstronautResponseDto;
import org.example.cs489finalexam.model.Astronaut;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AstronautService {
    AstronautResponseDto createAstronaut(AstronautRequestDto astronautRequestDto);
    Page<AstronautResponseDto> getAstronauts(Pageable pageable);
}

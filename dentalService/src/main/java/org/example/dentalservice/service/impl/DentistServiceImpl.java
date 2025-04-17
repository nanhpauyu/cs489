package org.example.dentalservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dentalservice.dto.request.DentistRequestDto;
import org.example.dentalservice.dto.response.DentistResponseDto;
import org.example.dentalservice.mapper.DentistMapper;
import org.example.dentalservice.model.Dentist;
import org.example.dentalservice.repository.DentistRepository;
import org.example.dentalservice.service.DentistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DentistServiceImpl implements DentistService {
    private final DentistRepository dentistRepository;
    private final DentistMapper dentistMapper;

    @Override
    public Optional<DentistResponseDto> createDentist(DentistRequestDto dentistRequestDto) {
        Dentist dentist = dentistMapper.dentistRequestDtoToDentist(dentistRequestDto);
        dentistRepository.save(dentist);
        DentistResponseDto dentistResponseDto = dentistMapper.dentistToDentistResponseDto(dentist);
        return Optional.of(dentistResponseDto);
    }
}

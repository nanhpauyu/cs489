package org.example.dentalservice.service;

import org.example.dentalservice.dto.request.DentistRequestDto;
import org.example.dentalservice.dto.response.DentistResponseDto;
import org.example.dentalservice.model.Dentist;

import java.util.Optional;

public interface DentistService {
    Optional<DentistResponseDto> createDentist(DentistRequestDto dentistRequestDto);
}

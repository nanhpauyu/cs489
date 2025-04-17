package org.example.dentalservice.service;

import org.example.dentalservice.dto.request.SurgeryRequestDto;
import org.example.dentalservice.dto.response.SurgeryResponseDto;

import java.util.Optional;

public interface SurgeryService {
    Optional<SurgeryResponseDto> createSurgery(SurgeryRequestDto surgeryRequestDto);
}

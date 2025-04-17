package org.example.dentalservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dentalservice.dto.request.SurgeryRequestDto;
import org.example.dentalservice.dto.response.SurgeryResponseDto;
import org.example.dentalservice.mapper.SurgeryMapper;
import org.example.dentalservice.model.Surgery;
import org.example.dentalservice.repository.SurgeryRepository;
import org.example.dentalservice.service.SurgeryService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SurgeryServiceImpl implements SurgeryService {
    private final SurgeryRepository surgeryRepository;
    private final SurgeryMapper surgeryMapper;
    @Override
    public Optional<SurgeryResponseDto> createSurgery(SurgeryRequestDto surgeryRequestDto) {
        Surgery surgery = surgeryMapper.surgeryRequestDtoToSurgery(surgeryRequestDto);
        surgeryRepository.save(surgery);
        SurgeryResponseDto surgeryResponseDto = surgeryMapper.surgeryToSurveyResponseDto(surgery);
        return Optional.ofNullable(surgeryResponseDto);
    }
}

package org.example.dentalservice.service;

import org.example.dentalservice.dto.request.PatientRequestDto;
import org.example.dentalservice.dto.response.PatientResponseDto;

import java.util.List;
import java.util.Optional;

public interface PatientService {
    PatientResponseDto createPatient(PatientRequestDto patientRequestDto);

    List<PatientResponseDto> getPatients();

    Optional<PatientResponseDto> getPatientById(Long id);

    PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto);

    void deletePatient(Long id);

}

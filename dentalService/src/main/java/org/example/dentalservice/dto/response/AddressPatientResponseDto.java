package org.example.dentalservice.dto.response;

import org.example.dentalservice.model.Patient;

public record AddressPatientResponseDto(
        AddressResponseDto addressResponseDto,
        PatientResponseDto patientResponseDto
) {
}

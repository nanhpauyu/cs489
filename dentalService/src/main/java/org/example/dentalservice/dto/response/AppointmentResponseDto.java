package org.example.dentalservice.dto.response;

import org.example.dentalservice.dto.request.DentistRequestDto;
import org.example.dentalservice.dto.request.PatientRequestDto;
import org.example.dentalservice.dto.request.SurgeryRequestDto;

import java.time.LocalDateTime;

public record AppointmentResponseDto(
        Long id,
        LocalDateTime appointmentDate,
        SurgeryResponseDto surgeryResponseDto,
        DentistResponseDto  dentistResponseDto,
        PatientResponseDto patientResponseDto
) {
}

package org.example.dentalservice.dto.request;

import java.time.LocalDateTime;

public record AppointmentRequestDto(
        LocalDateTime appointmentDate,
        SurgeryRequestDto surgeryRequestDto,
        DentistRequestDto dentistRequestDto,
        PatientRequestDto patientRequestDto
) {
}

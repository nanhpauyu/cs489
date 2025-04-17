package org.example.dentalservice.service;


import org.example.dentalservice.dto.request.AppointmentRequestDto;
import org.example.dentalservice.dto.response.AppointmentResponseDto;

import java.util.Optional;

public interface AppointmentService {
    Optional<AppointmentResponseDto> createAppointment(AppointmentRequestDto appointmentRequestDto);
    void deleteAppointment(AppointmentResponseDto appointmentResponseDto);
    Optional<AppointmentResponseDto> getAppointmentById(Long id);
}

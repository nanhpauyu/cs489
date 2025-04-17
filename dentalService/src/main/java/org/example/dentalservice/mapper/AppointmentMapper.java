package org.example.dentalservice.mapper;


import org.example.dentalservice.dto.request.AppointmentRequestDto;
import org.example.dentalservice.dto.response.AppointmentResponseDto;
import org.example.dentalservice.model.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AppointmentMapper {

    @Mapping(source = "dentistRequestDto", target = "dentist")
    @Mapping(source = "patientRequestDto", target = "patient")
    @Mapping(source = "surgeryRequestDto", target = "surgery")
    Appointment appointmentRequestDtoToAppointment(AppointmentRequestDto appointmentRequestDto);

    @Mapping(source = "dentist", target = "dentistResponseDto")
    @Mapping(source = "patient", target = "patientResponseDto")
    @Mapping(source = "surgery", target = "surgeryResponseDto")
    AppointmentResponseDto appointmentToAppointmentResponseDto(Appointment appointment);
}

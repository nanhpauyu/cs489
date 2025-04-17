package org.example.dentalservice.mapper;

import org.example.dentalservice.dto.request.PatientRequestDto;
import org.example.dentalservice.dto.response.PatientResponseDto;
import org.example.dentalservice.model.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PatientMapper {
    @Mapping(source = "addressRequestDto", target = "address")
    Patient patientRequestDtoToPatient(PatientRequestDto patientRequestDto);
    @Mapping(source = "address", target = "addressResponseDto")
    PatientResponseDto patientToPatientResponseDto(Patient patient);

    @Mapping(source = "address", target = "addressResponseDto")
    List<PatientResponseDto> patientsToPatentResponseDtoList(List<Patient> patients);
}

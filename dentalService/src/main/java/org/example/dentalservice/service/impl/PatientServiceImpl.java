package org.example.dentalservice.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.dentalservice.dto.request.PatientRequestDto;
import org.example.dentalservice.dto.response.PatientResponseDto;
import org.example.dentalservice.mapper.PatientMapper;
import org.example.dentalservice.model.Patient;
import org.example.dentalservice.repository.PatientRepository;
import org.example.dentalservice.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        Patient patient = patientMapper.patientRequestDtoToPatient(patientRequestDto);
        patientRepository.save(patient);
        PatientResponseDto responseDto = patientMapper.patientToPatientResponseDto(patient);
        return responseDto;
    }

    @Override
    public List<PatientResponseDto> getPatients() {
        return patientMapper.patientsToPatentResponseDtoList(patientRepository.findAll());
    }

    @Override
    public Optional<PatientResponseDto> getPatientById(Long id) {
        return Optional.ofNullable(patientMapper.patientToPatientResponseDto(patientRepository.findById(id).get()));
    }

    @Override
    public PatientResponseDto updatePatient(Long id, PatientRequestDto patientRequestDto) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            Patient updatedPatient = patientMapper.patientRequestDtoToPatient(patientRequestDto);
            updatedPatient.setId(patient.getId());
            patientRepository.save(updatedPatient);
            return patientMapper.patientToPatientResponseDto(updatedPatient);
        }
        return null;
    }

    @Override
    @Transactional
    public void deletePatient(Long id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patientRepository.delete(patient);
            return;
        }
        return;
    }


}

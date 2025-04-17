package org.example.dentalservice.controller;


import lombok.RequiredArgsConstructor;
import org.example.dentalservice.dto.request.PatientRequestDto;
import org.example.dentalservice.dto.response.AddressPatientResponseDto;
import org.example.dentalservice.dto.response.PatientResponseDto;
import org.example.dentalservice.service.AddressService;
import org.example.dentalservice.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adsweb/api/v1")
@RequiredArgsConstructor
public class MyController {

    private final PatientService patientService;
    private final AddressService addressService;

    @GetMapping("/patients")
    public ResponseEntity<List<PatientResponseDto>> getPatients() {
        return ResponseEntity.ok(patientService.getPatients());
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientResponseDto> getPatient(@PathVariable Long id) {
        Optional<PatientResponseDto> optionalPatientResponseDto = patientService.getPatientById(id);
        return optionalPatientResponseDto.map(patientResponseDto -> ResponseEntity.status(HttpStatus.FOUND).body(patientResponseDto)).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/patients")
    public ResponseEntity<PatientResponseDto> addPatient(@RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patientResponseDto = patientService.createPatient(patientRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(patientResponseDto);
    }

    @PutMapping("/patients/{id}")
    public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable Long id, @RequestBody PatientRequestDto patientRequestDto) {
        PatientResponseDto patientResponseDto = patientService.updatePatient(id, patientRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(patientResponseDto);
    }

    @DeleteMapping("/patients/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/addresses")
    public ResponseEntity<List<AddressPatientResponseDto>> getAddresses() {

        return ResponseEntity.ok(addressService.getAddresses());
    }
}

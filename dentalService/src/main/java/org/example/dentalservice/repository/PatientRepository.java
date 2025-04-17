package org.example.dentalservice.repository;

import org.example.dentalservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByName(String name);
//    Optional<Patient> findByPatientId(Long patientId);
}

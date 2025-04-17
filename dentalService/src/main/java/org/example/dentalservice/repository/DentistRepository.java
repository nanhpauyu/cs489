package org.example.dentalservice.repository;

import org.example.dentalservice.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
//    Optional<Dentist> findByDentistId(Long dentistId);
    Optional<Dentist> findByName(String name);
}

package org.example.dentalservice.repository;

import org.example.dentalservice.model.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
    Optional<Surgery> findByName(String name);
}

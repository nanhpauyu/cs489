package org.example.cs489finalexam.repository;

import org.example.cs489finalexam.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {
    Optional<Satellite> findByName(String name);
}

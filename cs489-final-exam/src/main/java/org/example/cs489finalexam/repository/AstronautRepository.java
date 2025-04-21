package org.example.cs489finalexam.repository;

import org.example.cs489finalexam.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}

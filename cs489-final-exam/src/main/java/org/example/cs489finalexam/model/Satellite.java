package org.example.cs489finalexam.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "satellites")
@Data
@NoArgsConstructor
public class Satellite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "satellite_id")
    private Long satelliteId;

    @Column(nullable = false, unique = true)
    private String name;

    private LocalDate launchDate;

    private String orbitType;

    private Boolean decommissioned;

    @ManyToMany
    @JoinTable(
            name="satellites_astronauts",
            joinColumns = {@JoinColumn(name = "satellite_id")},
            inverseJoinColumns = {@JoinColumn(name="astronaut_id")}
    )
    private List<Astronaut> astronauts = new ArrayList<>();

    public Satellite(String name, LocalDate launchDate, String orbitType, Boolean decommissioned) {
        this.name = name;
        this.launchDate = launchDate;
        this.orbitType = orbitType;
        this.decommissioned = decommissioned;
    }
}

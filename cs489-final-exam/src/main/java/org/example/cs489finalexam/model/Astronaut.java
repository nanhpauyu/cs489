package org.example.cs489finalexam.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "astronauts")
@Data
@NoArgsConstructor
public class Astronaut {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "astronaut_id")
    private Long astronautId;

    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;

    private Integer experienceYears;

    @ManyToMany(mappedBy = "astronauts" , fetch = FetchType.LAZY)
    private List<Satellite> satellites = new ArrayList<>();

    public Astronaut(String firstName, String lastName, Integer experienceYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.experienceYears = experienceYears;
    }
}

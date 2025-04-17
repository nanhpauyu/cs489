package org.example.dentalservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "dentists")
public class Dentist {

    @Id
    @Column(name = "dentist_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "")
    private List<Appointment> appointments = new ArrayList<>();


    public Dentist(String name) {
        this.name = name;
    }
}

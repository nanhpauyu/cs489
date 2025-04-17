package org.example.dentalservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "patients")
@NoArgsConstructor
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;


    @OneToMany(mappedBy = "" )
    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

package org.example.dentalservice.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "surgeries")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "surgery_id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "")
    private List<Appointment> appointments = new ArrayList<>();

    public Surgery(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}

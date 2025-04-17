package org.example.dentalservice.model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Normalized;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Data
@Table(name = "appointments")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appointment_id")
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentDate;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "surgery_id")
    private Surgery surgery;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Appointment(LocalDateTime appointmentDate, Surgery surgery, Dentist dentist, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.surgery = surgery;
        this.dentist = dentist;
        this.patient = patient;
    }
}

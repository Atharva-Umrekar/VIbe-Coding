package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "checkups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Checkup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long checkupId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    private LocalDate checkupDate;

    @Column(length = 2000)
    private String notes;
}

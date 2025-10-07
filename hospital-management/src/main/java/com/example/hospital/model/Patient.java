package com.example.hospital.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long patientId;

    // public Long getPatientId() {
    //     return patientId;
    // }

    // public void setPatientId(Long patientId) {
    //     this.patientId = patientId;
    // }

    @Column(unique = true, nullable = false)
    private String patientNo; // hospital issued

    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String gender;
    private String contactNumber;
    private String address;

    @Column(name = "created_at", updatable = false)
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = this.updatedAt = java.time.LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = java.time.LocalDateTime.now();
    }
}

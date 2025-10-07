package com.example.hospital.repository;

import com.example.hospital.model.PatientDisease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientDiseaseRepository extends JpaRepository<PatientDisease, Long> {}

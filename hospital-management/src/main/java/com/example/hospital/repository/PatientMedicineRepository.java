package com.example.hospital.repository;

import com.example.hospital.model.PatientMedicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientMedicineRepository extends JpaRepository<PatientMedicine, Long> {}

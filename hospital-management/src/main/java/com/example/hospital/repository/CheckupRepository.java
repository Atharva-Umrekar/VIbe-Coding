package com.example.hospital.repository;

import com.example.hospital.model.Checkup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckupRepository extends JpaRepository<Checkup, Long> {}

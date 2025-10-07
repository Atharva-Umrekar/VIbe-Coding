package com.example.hospital.repository;

import com.example.hospital.model.PromptOutput;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromptOutputRepository extends JpaRepository<PromptOutput, Long> {
    PromptOutput findFirstByPromptOrderByCreatedAtDesc(String prompt);
}

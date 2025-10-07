package com.example.hospital.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PromptOutput {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prompt;

    @Column(length = 4000)
    private String output;

    private LocalDateTime createdAt;

    public PromptOutput() {}

    public PromptOutput(String prompt, String output) {
        this.prompt = prompt;
        this.output = output;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getPrompt() { return prompt; }
    public void setPrompt(String prompt) { this.prompt = prompt; }
    public String getOutput() { return output; }
    public void setOutput(String output) { this.output = output; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

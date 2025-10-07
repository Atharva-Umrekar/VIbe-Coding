package com.example.hospital.service;

import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PatientService {
    private final PatientRepository repo;

    public PatientService(PatientRepository repo) { this.repo = repo; }

    public Patient create(Patient p) { return repo.save(p); }
    public Patient update(Long id, Patient p) {
        Patient existing = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found"));
        existing.setFirstName(p.getFirstName());
        existing.setLastName(p.getLastName());
        existing.setContactNumber(p.getContactNumber());
        existing.setAddress(p.getAddress());
        return repo.save(existing);
    }
    public void delete(Long id) { repo.deleteById(id); }
    public Optional<Patient> get(Long id) { return repo.findById(id); }
    public List<Patient> list() { return repo.findAll(); }
}

package com.openclassrooms.mediscreen.config;

import com.openclassrooms.mediscreen.model.Patient;
import com.openclassrooms.mediscreen.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientRepository patientRepository;

    public DataLoader(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void run(String... args) {
        if (patientRepository.count() == 0) {
            patientRepository.save(new Patient(null, "John", "Doe", LocalDate.of(1968, 6, 22), "M", "123 Main St", "555-1234"));
            patientRepository.save(new Patient(null, "Jane", "Smith", LocalDate.of(1972, 7, 15), "F", "456 Oak Ave", "555-5678"));
            patientRepository.save(new Patient(null, "Alice", "Brown", LocalDate.of(1980, 3, 10), "F", "789 Pine Rd", "555-8765"));
            patientRepository.save(new Patient(null, "Bob", "White", LocalDate.of(1955, 12, 2), "M", "321 Maple Ln", "555-4321"));
        }
    }
}
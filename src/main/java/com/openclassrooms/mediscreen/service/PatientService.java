package com.openclassrooms.mediscreen.service;

import com.openclassrooms.mediscreen.model.Patient;
import com.openclassrooms.mediscreen.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient findPatient(Patient patient) {
        return getAllPatients().stream()
                .filter(p -> p.getGivenName().equals(patient.getGivenName()) &&
                             p.getFamilyName().equals(patient.getFamilyName()) &&
                             p.getDateOfBirth().equals(patient.getDateOfBirth()))
                .findFirst()
                .orElse(null);
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Patient patient) {
        patientRepository.deletePatient(patient);
    }
}
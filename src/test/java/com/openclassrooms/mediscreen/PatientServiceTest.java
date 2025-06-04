package com.openclassrooms.mediscreen;

import com.openclassrooms.mediscreen.model.Patient;
import com.openclassrooms.mediscreen.repository.PatientRepository;
import com.openclassrooms.mediscreen.service.PatientService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {

    private PatientRepository patientRepository;
    private PatientService patientService;

    @BeforeEach
    void setUp() {
        patientRepository = mock(PatientRepository.class);
        patientService = new PatientService(patientRepository);
    }

    @Test
    void testAddAndGetPatient() {
        Patient patient = new Patient("Alice", "Brown", LocalDate.of(1980, 3, 10), "F", "789 Pine Rd", "555-8765");
        when(patientRepository.save(patient)).thenReturn(patient);
        Patient addedPatient = patientService.addPatient(patient);
        assertNotNull(addedPatient);
        assertEquals("Alice", addedPatient.getGivenName());
        assertEquals("Brown", addedPatient.getFamilyName());
        assertEquals(LocalDate.of(1980, 3, 10), addedPatient.getDateOfBirth());
        assertEquals("F", addedPatient.getGender());
    }
}
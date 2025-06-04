package com.openclassrooms.mediscreen.controller;

import com.openclassrooms.mediscreen.model.Patient;
import com.openclassrooms.mediscreen.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("add")
    public String addPatient(@RequestBody Patient patient) {
        return patientRepository.addPatient(patient);
    }

    
}
package com.smartcare.hospital.service;


import com.smartcare.hospital.entity.Patient;

import com.smartcare.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    // Method to register a new patient
    public Patient registerPatient(Patient patient) {


        // 1. Validate Full Name (Cannot be null or empty)
        if (patient.getFullName() == null || patient.getFullName().trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Patient full name is required and cannot be empty.");
        }

        // 2. Validate Gender (Cannot be null or empty)
        if (patient.getGender() == null || patient.getGender().trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Gender is required.");
        }

        // If all rules pass, save to the database
        return patientRepository.save(patient);
    }

    // Method to view all patients
    public List<Patient> getAllPatients() {

        return patientRepository.findAll();
    }

    // Method to delete a patient record
    public void deletePatient(int id) {

        patientRepository.deleteById(id);
    }

    public Patient getPatientById(int id){
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
    }
}

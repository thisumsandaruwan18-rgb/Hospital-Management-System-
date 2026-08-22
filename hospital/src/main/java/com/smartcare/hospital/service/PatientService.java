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

    // Register a new patient
    public Patient registerPatient(Patient patient) {

        if (patientRepository.existsById(patient.getPaId())) {
            throw new IllegalArgumentException("Patient ID " + patient.getPaId() + " already exists!");

        }

        //  Validate Full Name
        if (patient.getFullName() == null || patient.getFullName().trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Patient full name is required and cannot be empty.");
        }

        //  Validate Gender
        if (patient.getGender() == null || patient.getGender().trim().isEmpty()) {
            throw new IllegalArgumentException("Validation Error: Gender is required.");
        }

        String bloodGroup = patient.getBloodGroup();

        if (patient.getBloodGroup() == null || patient.getBloodGroup().trim().isEmpty() || !bloodGroup.matches("^(A|B|AB|O)[+-]$")) {
            throw new IllegalArgumentException("Validation Error: Invalid blood group! Please enter a valid one (e.g., A+, O-, B+, AB-).");
        }

        return patientRepository.save(patient);
    }

    // Method to view all patients
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    //Delete a patient record
    public void deletePatient(int id) {
        patientRepository.deleteById(id);
    }

    public Patient getPatientById(int id){
        return patientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Patient not found with ID: " + id));
    }

    public Patient updatePatient(int id,Patient updatedPatient) {
        Patient existingPatient = getPatientById(id);

        existingPatient.setPaId(updatedPatient.getPaId());
        existingPatient.setFullName(updatedPatient.getFullName());
        existingPatient.setGender(updatedPatient.getGender());
        existingPatient.setAddress(updatedPatient.getAddress());
        existingPatient.setBloodGroup(updatedPatient.getBloodGroup());
        existingPatient.setDob(updatedPatient.getDob());
        existingPatient.setContactNo(updatedPatient.getContactNo());
        existingPatient.setEmergencyContact(updatedPatient.getEmergencyContact());

        return patientRepository.save(existingPatient);
    }




}

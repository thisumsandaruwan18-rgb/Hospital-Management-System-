package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Patient;
import com.smartcare.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // POST API to add a patient
    @PostMapping("/register")
    public Patient registerPatient(@RequestBody Patient patient) {

        return patientService.registerPatient(patient);
    }

    // GET API to retrieve all patients
    @GetMapping("/all")
    public List<Patient> getAllPatients() {

        return patientService.getAllPatients();
    }

    //GET PATIENT using ID
    @GetMapping("{id}")
    public Patient getPatientById(@PathVariable int id) {
        return patientService.getPatientById(id);
    }

    // DELETE API to remove a patient
    @DeleteMapping("/delete/{id}")
    public String deletePatient(@PathVariable int id) {
        patientService.deletePatient(id);
        return "Patient record deleted successfully.";
    }

    //UPDATE patien Using ID
    @PutMapping("/update/{id}")
    public Patient updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }
}
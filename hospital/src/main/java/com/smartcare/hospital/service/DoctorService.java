package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    // add a new doctor
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // get a list of all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // delete a doctor
    public void deleteDoctor(int id){
        doctorRepository.deleteById(id);
    }

    //get doctor by id
    public Doctor getDoctorById(int id){
        return doctorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Doctor not found with ID: " + id));
    }

    
}

package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Doctor;
import com.smartcare.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;


    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor) {

        return doctorService.addDoctor(doctor);
    }


    @GetMapping("/all")
    public List<Doctor> getAllDoctors() {

        return doctorService.getAllDoctors();
    }

    @GetMapping ("/{id}")
    public Doctor getDoctorByID(@PathVariable int id){
        return doctorService.getDoctorById(id);
    }

    @DeleteMapping("/delete")
    public String deleteDoctor(@PathVariable int id){
        doctorService.deleteDoctor(id);
        return "Doctor deleted successfully.";
    }
    
}
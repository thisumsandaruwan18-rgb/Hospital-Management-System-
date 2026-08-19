package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @PostMapping("/add")
    public Admission addAdmission(@RequestBody Admission admission) {

        return admissionService.addAdmission(admission);
    }

    @GetMapping("/all")
    public List<Admission> getAllAdmissions() {

        return admissionService.getAllAdmissions();
    }
}
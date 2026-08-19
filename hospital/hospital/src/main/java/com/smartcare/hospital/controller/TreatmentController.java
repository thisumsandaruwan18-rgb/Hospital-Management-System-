
package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Treatment;
import com.smartcare.hospital.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @PostMapping("/add")
    public Treatment addTreatment(@RequestBody Treatment treatment) {
        return treatmentService.addTreatment(treatment);
    }

    @GetMapping("/all")
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }
}
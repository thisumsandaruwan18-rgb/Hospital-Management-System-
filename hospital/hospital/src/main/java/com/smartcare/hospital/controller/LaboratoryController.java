package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Laboratory;
import com.smartcare.hospital.service.LaboratoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/laboratory")
public class LaboratoryController {

    @Autowired
    private LaboratoryService laboratoryService;

    @PostMapping("/add")
    public Laboratory addTest(@RequestBody Laboratory laboratory) {
        return laboratoryService.addTest(laboratory);
    }

    @GetMapping("/all")
    public List<Laboratory> getAllTests() {
        return laboratoryService.getAllTests();
    }
}
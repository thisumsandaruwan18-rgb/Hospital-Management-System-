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

    //ADD Test
    @PostMapping("/add")
    public Laboratory addTest(@RequestBody Laboratory laboratory) {
        return laboratoryService.addTest(laboratory);
    }

    //GET All Test
    @GetMapping("/all")
    public List<Laboratory> getAllTests() {
        return laboratoryService.getAllTests();
    }

    //Get Test Using ID
    @GetMapping("/{id}")
    public Laboratory getTestById(@PathVariable int id){
        return laboratoryService.getTestById(id);
    }

    //UPDATE Test
    @PutMapping("/update/{id}")
    public Laboratory updateTest(@PathVariable int id, @RequestBody Laboratory laboratory){
        return laboratoryService.updateTest(id, laboratory);
    }

    //Delete Test
    @DeleteMapping("/delete/{id}")
    public String deleteTest(@PathVariable int id) {
        laboratoryService.deleteTest(id);
        return "Test deleted Successfully.";
    }

}
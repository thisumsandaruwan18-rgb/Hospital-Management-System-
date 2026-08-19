package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Laboratory;
import com.smartcare.hospital.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    //ADD Patient
    public Laboratory addTest(Laboratory laboratory){

        if (laboratoryRepository.existsById(laboratory.getTestId())){
            throw new IllegalArgumentException("Laboratory already exists");
        }
        return laboratoryRepository.save(laboratory);
    }


    public List<Laboratory> getAllTests() {
        return laboratoryRepository.findAll();
    }

    public Laboratory getTestById(int id){
        return laboratoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Laboratory Not Found"));
    }

    public Laboratory updateTest(int id,Laboratory updatedLaboratory){
        Laboratory existingLaboratory = getTestById(id);

        existingLaboratory.setDoId(updatedLaboratory.getDoId());
        existingLaboratory.setPaId(updatedLaboratory.getPaId());
        existingLaboratory.setTestName(updatedLaboratory.getTestName());
        existingLaboratory.setTestDate(updatedLaboratory.getTestDate());
        existingLaboratory.setTestId(updatedLaboratory.getTestId());
        existingLaboratory.setTechnicianName(updatedLaboratory.getTechnicianName());

        return laboratoryRepository.save(existingLaboratory);
    }

    public void deleteTest(int id){
        laboratoryRepository.deleteById(id);
    }

}



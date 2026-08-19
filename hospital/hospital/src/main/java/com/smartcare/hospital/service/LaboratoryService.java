package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Laboratory;
import com.smartcare.hospital.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService {

    @Autowired
    private LaboratoryRepository laboratoryRepository;

    public Laboratory addTest(Laboratory laboratory){
        return laboratoryRepository.save(laboratory);
    }
    public List<Laboratory> getAllTests() {
        return laboratoryRepository.findAll();
    }
}



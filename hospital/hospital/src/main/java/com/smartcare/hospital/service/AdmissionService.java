package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    public Admission addAdmission(Admission admission) {

        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {

        return admissionRepository.findAll();
    }


}
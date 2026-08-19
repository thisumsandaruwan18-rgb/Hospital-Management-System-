package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Admission;
import com.smartcare.hospital.entity.Room;
import com.smartcare.hospital.repository.AdmissionRepository;
import com.smartcare.hospital.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Admission addAdmission(Admission admission) {
        Room room = roomRepository.findById(admission.getRoId()).orElseThrow(() -> new IllegalArgumentException("Room Not Found"+admission.getRoId()));

        if (!"Available".equalsIgnoreCase(room.getRoStatus())){
            throw new IllegalArgumentException("Room is currently Not Available");
        }
        room.setRoStatus("Occupied");
        roomRepository.save(room);

        admission.setAdStatus("Admitted");
        return admissionRepository.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepository.findAll();
    }

}
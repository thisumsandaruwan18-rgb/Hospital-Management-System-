package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Treatment;
import com.smartcare.hospital.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public Treatment addTreatment(Treatment treatment) {
        return treatmentRepository.save(treatment);
    }

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Treatment getTreatmentById(int id) {
        return treatmentRepository.findById(id).get();
    }

    public Treatment updateTreatment(int id, Treatment updateTreatment) {
        Treatment existingTreatment = getTreatmentById(id);

        existingTreatment.setDiagnosis(updateTreatment.getDiagnosis());
        existingTreatment.setDoId(updateTreatment.getDoId());
        existingTreatment.setPaId(updateTreatment.getPaId());
        existingTreatment.setPrescriptionDetails(updateTreatment.getPrescriptionDetails());
        existingTreatment.setTreatDate(updateTreatment.getTreatDate());
        existingTreatment.setTreatId(updateTreatment.getTreatId());
        existingTreatment.setTreatNotes(updateTreatment.getTreatNotes());

        return treatmentRepository.save(existingTreatment);
    }

    public void deleteTreatment(int id) {
        treatmentRepository.deleteById(id);
    }
}

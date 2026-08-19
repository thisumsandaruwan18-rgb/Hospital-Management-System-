package com.smartcare.hospital.service;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment bookAppointment(Appointment appointment){
        boolean isClashing = appointmentRepository.existsByDoIdAndApDateAndApTime(
                appointment.getDoId(),
                appointment.getApDate(),
                appointment.getApTime()
        );

        if (isClashing) {
            throw new IllegalArgumentException("Appointment clash! The Doctor has Appointment at this time");
        }
        return appointmentRepository.save(appointment);
    }
    public List<Appointment>getAllAppointments(){
        return appointmentRepository.findAll();
    }

    public void deleteAppointment(int id){
        appointmentRepository.deleteById(id);
    }
}

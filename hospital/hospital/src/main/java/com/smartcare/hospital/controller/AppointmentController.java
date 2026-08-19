package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Appointment;
import com.smartcare.hospital.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/book")
    public ResponseEntity<?> bookAppointment(@RequestBody Appointment appointment){
        try{
            Appointment savedAppointment = appointmentService.bookAppointment(appointment);
            return ResponseEntity.ok(savedAppointment);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Appointment> getAllAppointment(){
        return appointmentService.getAllAppointments();
    }

    @DeleteMapping("/delete")
    public String deleteAppointment(@PathVariable int id){
        appointmentService.deleteAppointment(id);
        return "Appointment deleted successfully.";
    }

}

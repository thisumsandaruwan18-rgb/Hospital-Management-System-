package com.smartcare.hospital.repository;

import com.smartcare.hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    // Custom method to check for clashes
    boolean existsByDoIdAndApDateAndApTime(int doId, Date apDate, Time apTime);
}
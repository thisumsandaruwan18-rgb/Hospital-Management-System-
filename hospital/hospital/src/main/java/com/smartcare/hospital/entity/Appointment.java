package com.smartcare.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Time;


@Entity
@Table(name = "Appointment")
public class Appointment {

    @Id
    @Column(name = "Ap_ID")
    private int apId;

    @Column(name = "Ap_Date")
    private Date apDate;

    @Column(name = "ConsultationRoom")
    private String consultationRoom;

    @Column(name = "Ap_Status")
    private String apStatus;

    @Column(name = "Ap_Time")
    private Time apTime;

    @Column(name = "Do_ID")
    private int doId;

    @Column(name = "Pa_ID")
    private int paId;



    // Getters and Setters

    public int getApId() {
        return apId;
    }
    public void setApId(int apId) {
        this.apId = apId;
    }

    public Date getApDate() {
        return apDate;
    }
    public void setApDate(Date apDate) {
        this.apDate = apDate;
    }

    public String getConsultationRoom() {
        return consultationRoom;
    }
    public void setConsultationRoom(String consultationRoom) {
        this.consultationRoom = consultationRoom;
    }

    public String getApStatus() {
        return apStatus;
    }
    public void setApStatus(String apStatus) {
        this.apStatus = apStatus;
    }

    public Time getApTime() {
        return apTime;
    }
    public void setApTime(Time apTime) {
        this.apTime = apTime;
    }

    public int getDoId() {
        return doId;
    }
    public void setDoId(int doId) {
        this.doId = doId;
    }

    public int getPaId() {
        return paId;
    }
    public void setPaId(int paId) {
        this.paId = paId;

    }
}


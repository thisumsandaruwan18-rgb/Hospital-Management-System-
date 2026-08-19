package com.smartcare.hospital.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "Doctor")
public class Doctor extends Person {
    @Id
    @Column(name = "Do_ID")
    private int doId;

    @NotBlank(message = "Doctor name cannot be empty")
    @Column(name = "Do_Name")
    private String doName;

    @NotBlank(message = "Specialization is required")
    @Column(name = "Specialization")
    private String specialization;

    @NotBlank(message = "Qualification is required")
    @Column(name = "Qualification")
    private String qualification;

    @Min(value = 1, message = "Consultation fee must be greater than zero")
    @Column(name = "Consultation_Fee")
    private double consultationFee;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid contact number format")
    @Column(name = "Contact_No")
    private String contactNo;

    @Column(name = "De_ID")
    private int deId;

    // Getters and Setters

    public int getDoId() {
        return doId;
    }

    public void setDoId(int doId) {
        this.doId = doId;
    }

    public String getDoName() {
        return doName;
    }

    public void setDoName(String doName) {
        this.doName = doName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public int getDeId() {
        return deId;
    }

    public void setDeId(int deId) {
        this.deId = deId;
    }
}
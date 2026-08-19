package com.smartcare.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Treatment")
public class Treatment {

    @Id
    @Column(name = "Treat_ID")
    private int treatId;

    @Column(name = "Diagnosis")
    private String diagnosis;

    @Column(name = "PrescriptionDetails")
    private String prescriptionDetails;

    @Column(name = "Treat_Notes")
    private String treatNotes;

    @Column(name = "Treat_Date")
    private Date treatDate;

    @Column(name = "Pa_ID")
    private int paId;

    @Column(name = "Do_ID")
    private int doId;


    public int getTreatId() {
        return treatId;
    }
    public void setTreatId(int treatId) {
        this.treatId = treatId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescriptionDetails() {
        return prescriptionDetails;
    }
    public void setPrescriptionDetails(String prescriptionDetails) {
        this.prescriptionDetails = prescriptionDetails;
    }

    public String getTreatNotes() {
        return treatNotes;
    }
    public void setTreatNotes(String treatNotes) {
        this.treatNotes = treatNotes;
    }

    public Date getTreatDate() {
        return treatDate;
    }
    public void setTreatDate(Date treatDate) {
        this.treatDate = treatDate;
    }

    public int getPaId() {
        return paId;
    }
    public void setPaId(int paId) {
        this.paId = paId;
    }

    public int getDoId() {
        return doId;
    }
    public void setDoId(int doId) {
        this.doId = doId;
    }
}
package com.smartcare.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Admission")
public class Admission {

    @Id
    @Column(name = "Ad_ID")
    private int adId;

    @Column(name = "Ad_Status")
    private String adStatus;

    @Column(name = "Bed_Number")
    private int bedNumber;

    @Column(name = "Admit_Date")
    private Date admitDate;

    @Column(name = "Discharge_Date")
    private Date dischargeDate;

    @Column(name = "Pa_ID")
    private int paId;

    @Column(name = "Ro_ID")
    private int roId;

    // Getters and Setters

    public int getAdId() {
        return adId;
    }
    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdStatus() {
        return adStatus;
    }
    public void setAdStatus(String adStatus) {
        this.adStatus = adStatus;
    }

    public int getBedNumber() {
        return bedNumber;
    }
    public void setBedNumber(int bedNumber) {
        this.bedNumber = bedNumber;
    }

    public Date getAdmitDate() {
        return admitDate;
    }
    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }
    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public int getPaId() {
        return paId;
    }
    public void setPaId(int paId) {
        this.paId = paId;
    }

    public int getRoId() {
        return roId;
    }
    public void setRoId(int roId) {
        this.roId = roId;
    }
}
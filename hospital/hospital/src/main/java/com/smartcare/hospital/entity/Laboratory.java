package com.smartcare.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "Laboratory")
public class Laboratory {

    @Id
    @Column(name = "Test_ID")
    private int testId;

    @Column(name = "Test_Name")
    private String testName;

    @Column(name = "Test_Date")
    private Date testDate;

    @Column(name = "Test_Result")
    private String testResult;

    @Column(name = "TechnicianName")
    private String technicianName;

    @Column(name = "Test_Status")
    private String testStatus;

    @Column(name = "Pa_ID")
    private int paId;

    @Column(name = "Do_ID")
    private int doId;


    // Getters and Setters

    public int getTestId() {
        return testId;
    }
    public void setTestId(int testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }
    public void setTestName(String testName) {
        this.testName = testName;
    }

    public Date getTestDate() {
        return testDate;
    }
    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    public String getTestResult() {
        return testResult;
    }
    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTechnicianName() {
        return technicianName;
    }
    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }

    public String getTestStatus() {
        return testStatus;
    }
    public void setTestStatus(String testStatus) {
        this.testStatus = testStatus;
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

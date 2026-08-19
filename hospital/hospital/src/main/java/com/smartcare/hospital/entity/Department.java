package com.smartcare.hospital.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @Column(name = "De_ID")
    private int deId;

    @Column(name = "De_Name")
    private String deName;

    @Column(name = "Location")
    private String location;

    @Column(name = "HeadDoctor")
    private String headDoctor;



    // Getters and Setters

    public int getDeId() {
        return deId;
    }
    public void setDeId(int deId) {
        this.deId = deId;
    }

    public String getDeName() {
        return deName;
    }
    public void setDeName(String deName) {
        this.deName = deName;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public String getHeadDoctor() {
        return headDoctor;
    }
    public void setHeadDoctor(String headDoctor) {
        this.headDoctor = headDoctor;
    }
}
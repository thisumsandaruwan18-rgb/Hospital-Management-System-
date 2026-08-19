package com.smartcare.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Person {

    @Column(name = "Contact_No")
    private String contactNo;

    public String getContactNo() {

        return contactNo;
    }

    public void setContactNo(String contactNo) {

        this.contactNo = contactNo;
    }
}
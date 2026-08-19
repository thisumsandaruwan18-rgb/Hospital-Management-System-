package com.smartcare.hospital.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Room {

    @Id
    @Column(name = "Ro_ID")
    private int roId;

    @Column(name = "RoomCategory")
    private String roomCategory;

    @Column(name = "Ro_Status")
    private String roStatus;

    // Get and Set


    public int getRoId() {

        return roId;
    }

    public void setRoId(int roId) {

        this.roId = roId;
    }

    public String getRoomCategory() {

        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {

        this.roomCategory = roomCategory;
    }

    public String getRoStatus() {

        return roStatus;
    }

    public void setRoStatus(String roStatus) {

        this.roStatus = roStatus;
    }
}


package com.smartcare.hospital.controller;

import com.smartcare.hospital.entity.Room;
import com.smartcare.hospital.service.RoomService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private RoomService roomService;

    @PostMapping("/add")
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    @GetMapping("all")
    public List<Room> getAllRoom(){
        return roomService.getAllRoom();
    }
}

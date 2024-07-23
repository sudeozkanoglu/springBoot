package com.example.demoproject.controller;

import com.example.demoproject.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demoproject.entity.Room;


import java.util.List;

@RestController
@RequestMapping(path = "/room/v1")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping(path = "getAllRooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping(path = "savedRoom")
    public void saveRoom(@RequestBody Room room) {
        roomService.saveRoom(room);
    }
}

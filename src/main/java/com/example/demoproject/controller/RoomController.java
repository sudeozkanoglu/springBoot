package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.repository.RoomRepository;
import com.example.demoproject.repository.RoomTypeRepository;
import com.example.demoproject.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demoproject.entity.Room;
import org.springframework.web.server.ResponseStatusException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/room/v1")
@RequiredArgsConstructor
public class RoomController {

    private final RoomService roomService;
    private final RoomRepository roomRepository;
    private final RoomTypeRepository roomTypeRepository;

    @GetMapping(path = "getAllRooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @PostMapping(path = "savedRoom")
    public void saveRoom(@RequestBody Room room) {
        roomService.saveRoom(room);
    }

    @DeleteMapping(path = "deleteRoom/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId) {
        return roomService.deleteRoom(roomId);
    }
}

package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.entity.RoomType;
import com.example.demoproject.repository.RoomTypeRepository;
import com.example.demoproject.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/roomType/v1")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;
    private final RoomTypeRepository roomTypeRepository;

    @GetMapping(path = "getAllRoomTypes")
    public List<RoomType> getAllRoomTypes() {
        return roomTypeService.getAllRoomTypes();
    }

    @PostMapping(path = "savedRoomTypes")
    public void saveRoomType(@RequestBody RoomType roomType) {
        roomTypeService.savedRoomType(roomType);
    }

    @DeleteMapping(path = "deleteRoomType/{id}")
    public Map<String, Boolean> deleteRoomType(@PathVariable(value = "id") Long roomTypeId) {
        return roomTypeService.deleteRoomType(roomTypeId);
    }
}

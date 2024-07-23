package com.example.demoproject.controller;

import com.example.demoproject.entity.RoomType;
import com.example.demoproject.service.RoomTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/roomType/v1")
@RequiredArgsConstructor
public class RoomTypeController {

    private final RoomTypeService roomTypeService;

    @GetMapping(path = "getAllRoomTypes")
    public List<RoomType> getAllRoomTypes() {
        return roomTypeService.getAllRoomTypes();
    }

    @PostMapping(path = "savedRoomTypes")
    public void saveRoomType(@RequestBody RoomType roomType) {
        roomTypeService.savedRoomType(roomType);
    }
}

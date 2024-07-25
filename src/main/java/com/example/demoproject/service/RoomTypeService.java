package com.example.demoproject.service;

import com.example.demoproject.entity.RoomType;
import com.example.demoproject.repository.RoomTypeRepository;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RoomTypeService {
    private final RoomTypeRepository roomTypeRepository;

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public void savedRoomType(RoomType roomType) {
        RoomType savedRoomType = new RoomType();
        savedRoomType.setTypeName(roomType.getTypeName());
        savedRoomType.setPrice(roomType.getPrice());
        roomTypeRepository.save(roomType);
    }

    public Map<String, Boolean> deleteRoomType(Long roomTypeId)
    {
        RoomType roomType = roomTypeRepository.findById(roomTypeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room Type is not found for this id :: " + roomTypeId));
        roomTypeRepository.delete(roomType);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

package com.example.demoproject.service;

import com.example.demoproject.entity.RoomType;
import com.example.demoproject.repository.RoomTypeRepository;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

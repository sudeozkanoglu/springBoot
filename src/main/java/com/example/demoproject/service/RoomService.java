package com.example.demoproject.service;

import com.example.demoproject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demoproject.entity.Room;


import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;


    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public void saveRoom(Room room) {
        Room savedRoom = new Room();
        savedRoom.setRoomNumber(room.getRoomNumber());
        savedRoom.setRoomFloor(room.getRoomFloor());
        savedRoom.setRoomView(room.getRoomView());
        roomRepository.save(savedRoom);
    }
}

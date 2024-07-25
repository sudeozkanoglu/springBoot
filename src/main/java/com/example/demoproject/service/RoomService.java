package com.example.demoproject.service;

import com.example.demoproject.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.example.demoproject.entity.Room;
import org.springframework.web.server.ResponseStatusException;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Boolean> deleteRoom(Long roomId)
    {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Room is not found for this id :: " + roomId));
        roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

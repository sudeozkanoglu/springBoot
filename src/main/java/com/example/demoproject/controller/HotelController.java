package com.example.demoproject.controller;

import com.example.demoproject.entity.Hotel;
import com.example.demoproject.repository.HotelRepository;
import com.example.demoproject.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/hotel/v1")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;
    private final HotelRepository hotelRepository;

    @GetMapping(path = "getAllHotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping(path = "savedHotel")
    public void savedHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
    }

    @DeleteMapping(path = "deleteHotel/{id}")
    public Map<String, Boolean> deleteHotel(@PathVariable(value = "id") Long hotel_id) {
        return hotelService.deleteHotel(hotel_id);
    }
}

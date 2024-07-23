package com.example.demoproject.controller;

import com.example.demoproject.entity.Hotel;
import com.example.demoproject.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hotel/v1")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @GetMapping(path = "getAllHotels")
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    @PostMapping(path = "savedHotel")
    public void savedHotel(@RequestBody Hotel hotel) {
        hotelService.saveHotel(hotel);
    }
}

package com.example.demoproject.service;

import com.example.demoproject.entity.Hotel;
import com.example.demoproject.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    public void saveHotel(Hotel hotel)
    {
        Hotel hotelSaved = new Hotel();
        hotelSaved.setHotelName(hotel.getHotelName());
        hotelSaved.setHotelOwner(hotel.getHotelOwner());
        hotelSaved.setHotelEmployeesNumber(hotel.getHotelEmployeesNumber());
        hotelSaved.setHotelCustomerNumber(hotel.getHotelCustomerNumber());
        hotelSaved.setHotelFoundingDate(hotel.getHotelFoundingDate());
        hotelRepository.save(hotelSaved);
    }
}
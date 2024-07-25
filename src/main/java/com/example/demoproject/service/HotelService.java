package com.example.demoproject.service;

import com.example.demoproject.entity.Hotel;
import com.example.demoproject.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Boolean> deleteHotel(Long hotel_id)
    {
        Hotel hotel = hotelRepository.findById(hotel_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hotel is not found for this id :: " + hotel_id));
        hotelRepository.delete(hotel);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
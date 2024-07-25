package com.example.demoproject.service;

import com.example.demoproject.entity.Rezervation;
import com.example.demoproject.repository.RezervationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RezervationService  {

    private final RezervationRepository rezervationRepository;

    public List<Rezervation> getAllRezervation() {
        return rezervationRepository.findAll();
    }

    public void savedRezervation(Rezervation rezervation) {
        Rezervation savedRezervation = new Rezervation();
        savedRezervation.setCheckinDate(rezervation.getCheckinDate());
        savedRezervation.setCheckoutDate(rezervation.getCheckoutDate());
        rezervationRepository.save(savedRezervation);
    }

    public Map<String, Boolean> deleteReservation(Long rezervationId)
    {
        Rezervation rezervation = rezervationRepository.findById(rezervationId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation is not found for this id :: " + rezervationId));
        rezervationRepository.delete(rezervation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}


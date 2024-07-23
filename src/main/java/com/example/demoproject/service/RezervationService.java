package com.example.demoproject.service;

import com.example.demoproject.entity.Rezervation;
import com.example.demoproject.repository.RezervationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}


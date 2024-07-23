package com.example.demoproject.service;

import com.example.demoproject.entity.Relatives;
import com.example.demoproject.repository.RelativesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RelativesService {

    private final RelativesRepository relativesRepository;

    public List<Relatives> getAllRelatives() {
        return relativesRepository.findAll();
    }

    public void saveRelatives (Relatives relatives)
    {
        Relatives relativesSaved = new Relatives();
        relativesSaved.setRelativeFirstName(relatives.getRelativeFirstName());
        relativesSaved.setRelativeLastName(relatives.getRelativeLastName());
        relativesSaved.setRelativeIdentityNumber(relatives.getRelativeIdentityNumber());
        relativesSaved.setRelativeRecordNumber(relatives.getRelativeRecordNumber());
        relativesSaved.setRelativeGender(relatives.getRelativeGender());
        relativesSaved.setRelativeBirthDate(relatives.getRelativeBirthDate());
        relativesSaved.setRelativeMarialStatus(relatives.getRelativeMarialStatus());
        relativesSaved.setRelativeType(relativesSaved.getRelativeType());
        relativesRepository.save(relativesSaved);
    }
}

package com.example.demoproject.service;

import com.example.demoproject.entity.SeasonalEmployee;
import com.example.demoproject.repository.EmployeeRepository;
import com.example.demoproject.repository.SeasonalEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SeasonalEmployeeService {

    private final EmployeeRepository employeeRepository;
    private final SeasonalEmployeeRepository seasonalEmployeeRepository;

    public List<SeasonalEmployee> getAllSeasonalEmployees() {
        return seasonalEmployeeRepository.findAll();
    }

    public void savedSeasonalEmployee(SeasonalEmployee seasonalEmployee) {
        SeasonalEmployee savedSeasonalEmployee = new SeasonalEmployee();
        savedSeasonalEmployee.setSeasonalIdentityNumber(seasonalEmployee.getSeasonalIdentityNumber());
        savedSeasonalEmployee.setSeasonalSalary(seasonalEmployee.getSeasonalSalary());
        savedSeasonalEmployee.setSeasonalType(seasonalEmployee.getSeasonalType());
        seasonalEmployeeRepository.save(seasonalEmployee);
    }

}

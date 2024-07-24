package com.example.demoproject.controller;

import com.example.demoproject.entity.SeasonalEmployee;
import com.example.demoproject.service.SeasonalEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/seasonalEmployee/v1")
@RequiredArgsConstructor
public class SeasonalEmployeeController {

    private final SeasonalEmployeeService seasonalEmployeeService;

    @GetMapping(path = "getAllSeasonalEmployee")
    public List<SeasonalEmployee> getAllSeasonalEmployee() {
        return seasonalEmployeeService.getAllSeasonalEmployees();
    }

    @PostMapping(path = "savedSeasonalEmployee")
    public void saveSeasonalEmployee(@RequestBody SeasonalEmployee seasonalEmployee) {
        seasonalEmployeeService.savedSeasonalEmployee(seasonalEmployee);
    }
}

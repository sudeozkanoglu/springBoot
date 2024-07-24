package com.example.demoproject.controller;

import com.example.demoproject.entity.PermanentEmployee;
import com.example.demoproject.service.PermanentEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/permanentEmployee/v1")
@RequiredArgsConstructor
public class PermanentEmployeeController {

    private final PermanentEmployeeService permanentEmployeeService;

    @GetMapping(path = "getAllPermanentEmployee")
    public List<PermanentEmployee> getAllPermanentEmployee() {
        return permanentEmployeeService.getAllPermanentEmployees();
    }

    @PostMapping(path = "savedPermanentEmployee")
    public void savePermanentEmployee(@RequestBody PermanentEmployee permanentEmployee) {
        permanentEmployeeService.savedPermanentEmployee(permanentEmployee);
    }

}

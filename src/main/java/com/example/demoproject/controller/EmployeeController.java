package com.example.demoproject.controller;

import com.example.demoproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demoproject.entity.Employee;

import java.util.List;

@RestController
@RequestMapping(path = "/employee/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping(path = "getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "savedEmployee")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.savedEmployee(employee);
    }
}

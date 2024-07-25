package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.repository.EmployeeRepository;
import com.example.demoproject.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demoproject.entity.Employee;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee/v1")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeRepository employeeRepository;

    @GetMapping(path = "getAllEmployees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "savedEmployee")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.savedEmployee(employee);
    }

    @DeleteMapping(path = "deleteEmployee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employee_id) {
        return employeeService.deleteEmployee(employee_id);
    }
}

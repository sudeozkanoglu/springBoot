package com.example.demoproject.service;

import com.example.demoproject.entity.Employee;
import com.example.demoproject.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void savedEmployee(Employee employee) {
        Employee savedEmployee = new Employee();
        savedEmployee.setEmployeeName(employee.getEmployeeName());
        savedEmployee.setEmployeeSurname(employee.getEmployeeSurname());
        savedEmployee.setEmployeeBirthDate(employee.getEmployeeBirthDate());
        savedEmployee.setEmployeeMarialStatus(employee.getEmployeeMarialStatus());
        savedEmployee.setEmployeeStartDate(employee.getEmployeeStartDate());
        savedEmployee.setEmployeeDepartment(employee.getEmployeeDepartment());
        savedEmployee.setEmployeeType(employee.getEmployeeType());
        employeeRepository.save(savedEmployee);
    }

    public Map<String, Boolean> deleteEmployee(Long employee_id)
    {
        Employee employee = employeeRepository.findById(employee_id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee is not found for this id :: " + employee_id));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

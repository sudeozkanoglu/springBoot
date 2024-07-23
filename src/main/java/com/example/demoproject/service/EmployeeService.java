package com.example.demoproject.service;

import com.example.demoproject.entity.Employee;
import com.example.demoproject.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

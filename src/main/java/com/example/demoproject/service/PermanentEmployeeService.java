package com.example.demoproject.service;

import com.example.demoproject.entity.PermanentEmployee;
import com.example.demoproject.repository.EmployeeRepository;
import com.example.demoproject.repository.PermanentEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermanentEmployeeService {

    private final PermanentEmployeeRepository permanentEmployeeRepository;
    private final EmployeeRepository employeeRepository;

    public List<PermanentEmployee> getAllPermanentEmployees() {
        return permanentEmployeeRepository.findAll();
    }

    public void savedPermanentEmployee(PermanentEmployee permanentEmployee) {
        PermanentEmployee savedPermanentEmployee = new PermanentEmployee();
        savedPermanentEmployee.setPerEmpIdentityNumber(permanentEmployee.getPerEmpIdentityNumber());
        permanentEmployeeRepository.save(permanentEmployee);
    }
}

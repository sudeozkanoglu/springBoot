package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.repository.IncomeRepository;
import com.example.demoproject.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.demoproject.entity.Income;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/income/v1")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;
    private final IncomeRepository incomeRepository;

    @GetMapping(path = "getAllIncomes")
    public List<Income> getAllIncome() {
        return incomeService.getAllIncome();
    }

    @PostMapping(path = "savedIncome")
    public void saveIncome(@RequestBody Income income) {
        incomeService.savedIncome(income);
    }

    @DeleteMapping(path = "deleteIncome/{id}")
    public Map<String, Boolean> deleteIncome(@PathVariable(value = "id") Long incomeId) {
        Income income = incomeRepository.findById(incomeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Income is not found for this id :: " + incomeId));
        incomeRepository.delete(income);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

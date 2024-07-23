package com.example.demoproject.controller;

import com.example.demoproject.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.demoproject.entity.Income;

import java.util.List;

@RestController
@RequestMapping(path = "/income/v1")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping(path = "getAllIncomes")
    public List<Income> getAllIncome() {
        return incomeService.getAllIncome();
    }

    @PostMapping(path = "savedIncome")
    public void saveIncome(@RequestBody Income income) {
        incomeService.savedIncome(income);
    }
}

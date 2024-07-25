package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.entity.Expense;
import com.example.demoproject.repository.ExpenseRepository;
import com.example.demoproject.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/expense/v1")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ExpenseRepository expenseRepository;

    @GetMapping(path = "getAllExpenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping(path = "savedExpense")
    public void saveExpense(@RequestBody Expense expense) {
        expenseService.saveExpense(expense);
    }

    @DeleteMapping(path = "deleteExpense/{id}")
    public Map<String, Boolean> deleteExpense(@PathVariable(value = "id") Long expenseId) {
        return expenseService.deleteExpense(expenseId);
    }
}

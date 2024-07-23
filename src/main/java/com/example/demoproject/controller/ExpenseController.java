package com.example.demoproject.controller;

import com.example.demoproject.entity.Expense;
import com.example.demoproject.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/expense/v1")
@RequiredArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;

    @GetMapping(path = "getAllExpenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @PostMapping(path = "savedExpense")
    public void saveExpense(@RequestBody Expense expense) {
        expenseService.saveExpense(expense);
    }
}

package com.example.demoproject.service;

import com.example.demoproject.entity.Expense;
import com.example.demoproject.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public void saveExpense(Expense expense) {
        Expense savedExpense = new Expense();
        savedExpense.setExpenseType(expense.getExpenseType());
        savedExpense.setExpenseDate(expense.getExpenseDate());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(savedExpense);
    }

    public Map<String, Boolean> deleteExpense(Long expenseId)
    {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense is not found for this id :: " + expenseId));
        expenseRepository.delete(expense);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

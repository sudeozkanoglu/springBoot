package com.example.demoproject.service;

import com.example.demoproject.entity.Expense;
import com.example.demoproject.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
}

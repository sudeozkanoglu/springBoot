package com.example.demoproject.service;

import com.example.demoproject.entity.Income;
import com.example.demoproject.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;

    public List<Income> getAllIncome(){
        return incomeRepository.findAll();
    }

    public void savedIncome(Income income){
        Income savedIncome = new Income();
        savedIncome.setIncomeType(income.getIncomeType());
        savedIncome.setAmount(income.getAmount());
        incomeRepository.save(savedIncome);
    }
}

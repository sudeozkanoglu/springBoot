package com.example.demoproject.service;

import com.example.demoproject.entity.Income;
import com.example.demoproject.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Boolean> deleteIncome(Long incomeId)
    {
        Income income = incomeRepository.findById(incomeId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Income is not found for this id :: " + incomeId));
        incomeRepository.delete(income);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

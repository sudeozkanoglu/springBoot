package com.example.demoproject.service;

import com.example.demoproject.entity.Discount;
import com.example.demoproject.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscountService {

    private final DiscountRepository discountRepository;

    public List<Discount>getAllDiscount(){
        return discountRepository.findAll();
    }

    public void saveDiscount(Discount discount){
        Discount saveDiscount = new Discount();
        saveDiscount.setEmployeeDiscount(discount.getEmployeeDiscount());
        saveDiscount.setPermanentDiscount(discount.getPermanentDiscount());
        discountRepository.save(saveDiscount);
    }
}

package com.example.demoproject.service;

import com.example.demoproject.entity.Discount;
import com.example.demoproject.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, Boolean> deleteDiscount(Long discountId)
    {
        Discount discount = discountRepository.findById(discountId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact Information is not found for this id :: " + discountId));
        discountRepository.delete(discount);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

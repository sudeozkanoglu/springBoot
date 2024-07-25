package com.example.demoproject.controller;

import com.example.demoproject.entity.ContactInformation;
import com.example.demoproject.entity.Discount;
import com.example.demoproject.repository.DiscountRepository;
import com.example.demoproject.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/discount/v1")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;
    private final DiscountRepository discountRepository;

    @GetMapping(path = "getAllDiscount")
    public List<Discount> getAllDiscount() {
        return discountService.getAllDiscount();
    }

    @PostMapping(path = "savedDiscount")
    public void saveDiscount(@RequestBody Discount discount) {
        discountService.saveDiscount(discount);
    }

    @DeleteMapping(path = "deleteDiscount/{id}")
    public Map<String, Boolean> deleteDiscount(@PathVariable(value = "id") Long discountId) {
        return discountService.deleteDiscount(discountId);
    }
}

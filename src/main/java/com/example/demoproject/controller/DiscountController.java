package com.example.demoproject.controller;

import com.example.demoproject.entity.Discount;
import com.example.demoproject.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/discount/v1")
@RequiredArgsConstructor
public class DiscountController {

    private final DiscountService discountService;

    @GetMapping(path = "getAllDiscount")
    public List<Discount> getAllDiscount() {
        return discountService.getAllDiscount();
    }

    @PostMapping(path = "savedDiscount")
    public void saveDiscount(@RequestBody Discount discount) {
        discountService.saveDiscount(discount);
    }
}

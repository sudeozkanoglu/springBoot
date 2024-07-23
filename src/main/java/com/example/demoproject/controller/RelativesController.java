package com.example.demoproject.controller;

import com.example.demoproject.entity.Relatives;
import com.example.demoproject.service.RelativesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/relatives/v1")
@RequiredArgsConstructor
public class RelativesController {

    private final RelativesService relativesService;

    @GetMapping(path = "getAllRelatives")
    public List<Relatives> getAllRelatives(){
        return relativesService.getAllRelatives();
    }

    @PostMapping(path = "savedRelative")
    public void saveRelative(@RequestBody Relatives relatives){
        relativesService.saveRelatives(relatives);
    }
}

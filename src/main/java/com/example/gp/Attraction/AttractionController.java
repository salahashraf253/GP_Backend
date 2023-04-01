package com.example.gp.Attraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
    @Autowired
    private AttractionService attractionService;


    @GetMapping("")
    public List<Attraction> getAllAttraction() {
        return attractionService.getAllAttractions();
    }
}

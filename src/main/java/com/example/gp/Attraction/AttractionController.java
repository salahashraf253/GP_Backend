package com.example.gp.Attraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/attractions")
public class AttractionController {
    @Autowired
    private AttractionService attractionService;


    @GetMapping("")
    public List<Attraction> getAllAttraction() {
        return attractionService.getAllAttractions();
    }

    @PostMapping("")
    public void addAttraction(@RequestBody List<Attraction> attractions) {
        attractionService.addAttractions(attractions);
    }

    @GetMapping("/{attractionId}")
    public Attraction getAttractionById(@PathVariable int attractionId) {
        return attractionService.getAttractionById(attractionId);
    }
}

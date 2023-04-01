package com.example.gp.Attraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttractionService {
    @Autowired
    private AttractionRepo attractionRepo;

    public List<Attraction> getAllAttractions() {
        return attractionRepo.findAll();
    }

}

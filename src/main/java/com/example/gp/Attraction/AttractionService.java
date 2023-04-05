package com.example.gp.Attraction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttractionService {
    @Autowired
    private AttractionRepo attractionRepo;

    public List<Attraction> getAllAttractions() {
        return attractionRepo.findAll();
    }

    public List<Attraction> getAllHotelsById(Integer[] attractionsId){
        List<Attraction> attractions= new ArrayList<>();
        for (int id : attractionsId){
            attractions.add((this.getAttractionById(id)));
        }
        return attractions;
    }

    public Attraction getAttractionById(int attractionId){
        return attractionRepo.findById(attractionId);
    }

}

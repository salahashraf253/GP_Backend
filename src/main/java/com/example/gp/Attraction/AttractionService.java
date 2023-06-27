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

    public List<Attraction> getAllAttractionsById(Integer[] attractionsId){
        List<Attraction> attractions= new ArrayList<>();
        for (int id : attractionsId){
            Attraction attraction =this.getAttractionById(id);
            if(attraction != null){
                attractions.add(attraction);
            }
            // attractions.add((this.getAttractionById(id)));
        }
        return attractions;
    }

    public Attraction getAttractionById(int attractionId){
        return attractionRepo.findById(attractionId);
    }

    public void addAttractions(List<Attraction> attractions) {
        for(Attraction attraction : attractions) {
            try{
                attractionRepo.save(attraction);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

}

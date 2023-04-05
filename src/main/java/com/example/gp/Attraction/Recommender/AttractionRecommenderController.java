package com.example.gp.Attraction.Recommender;

import com.example.gp.Attraction.Attraction;
import com.example.gp.Attraction.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("attractions/recommender/")
public class AttractionRecommenderController {
    @Autowired
    private AttractionRecommenderService attractionRecommenderService;
    @Autowired
    private AttractionService attractionService;

    @GetMapping("/{userId}/{city}")
    public List<Attraction> recommendAttraction(@PathVariable int userId,@PathVariable String city ){
        Integer [] recommendedAttractionsId =attractionRecommenderService.recommend(userId,city);
        return attractionService.getAllHotelsById(recommendedAttractionsId);
    }

}

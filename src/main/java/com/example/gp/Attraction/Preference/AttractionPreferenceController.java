package com.example.gp.Attraction.Preference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import  java.util.List;

@RestController
@RequestMapping("/attractions/preferences")
public class AttractionPreferenceController {
    @Autowired
    private AttractionPreferenceService attractionPreferenceService;

    public AttractionPreferenceController() {
    }

    @PostMapping("")
    public void addAttractionPreference(@RequestBody List<AttractionPreference> attractionPreferences) {
        this.attractionPreferenceService.addAttractionPreferences(attractionPreferences);
    }

    
}

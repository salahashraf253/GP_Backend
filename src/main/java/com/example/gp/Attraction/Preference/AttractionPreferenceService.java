package com.example.gp.Attraction.Preference;

import com.example.gp.Hotel.Preference.HotelPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AttractionPreferenceService {
    @Autowired
    AttractionPreferenceRepo attractionPreferenceRepo;

    public AttractionPreference findById(int preferenceId) {
        return this.attractionPreferenceRepo.findById(preferenceId);
    }

    public List<AttractionPreference> findAll() {
        return this.attractionPreferenceRepo.findAll();
    }


    public Set<AttractionPreference> findAllById(List<Integer> attractionPreferencesId) {
        Set<AttractionPreference> attractionPreferenceSet = new HashSet<>();
        for (int id : attractionPreferencesId) {
            attractionPreferenceSet.add(this.findById(id));
        }
        return attractionPreferenceSet;
    }
}

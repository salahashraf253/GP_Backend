package com.example.gp.Hotel.Preference;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelPreferenceService {
    private HotelPreferenceRepo hotelPreferenceRepo;

    public HotelPreferenceService(HotelPreferenceRepo hotelPreferenceRepo){
        this.hotelPreferenceRepo=hotelPreferenceRepo;
    }

    public void addPreference(HotelPreference hotelPreference){
        this.hotelPreferenceRepo.save(hotelPreference);
    }

    public HotelPreference findById(int preferenceId) {
        return this.hotelPreferenceRepo.findById(preferenceId);
    }

    public List<HotelPreference> findAll() {
        return this.hotelPreferenceRepo.findAll();
    }

    public void save(HotelPreference hotelPreference){
        this.hotelPreferenceRepo.save(hotelPreference);
    }

    public void addHotelPreferences(List<HotelPreference> hotelPreferences) {
        this.hotelPreferenceRepo.saveAll(hotelPreferences);
    }
}

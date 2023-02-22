package com.example.gp.Service;

import com.example.gp.Model.HotelPreference;
import com.example.gp.Repository.HotelPreferenceRepo;
import org.springframework.stereotype.Service;

@Service
public class HotelPreferenceService {
    private HotelPreferenceRepo hotelPreferenceRepo;

    public HotelPreferenceService(HotelPreferenceRepo hotelPreferenceRepo){
        this.hotelPreferenceRepo=hotelPreferenceRepo;
    }

    public void addPreference(HotelPreference hotelPreference){
        hotelPreferenceRepo.save(hotelPreference);
    }

    public HotelPreference findById(int preferenceId) {
        return hotelPreferenceRepo.findById(preferenceId);
    }
}

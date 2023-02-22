package com.example.gp.Repository;

import com.example.gp.Model.HotelPreference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelPreferenceRepo extends JpaRepository<HotelPreference, Long> {
    public HotelPreference findById(int preferenceId);
}

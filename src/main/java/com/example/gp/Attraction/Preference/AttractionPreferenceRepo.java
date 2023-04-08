package com.example.gp.Attraction.Preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionPreferenceRepo extends JpaRepository<AttractionPreference,Long> {
    AttractionPreference findById(int preferenceId);
}

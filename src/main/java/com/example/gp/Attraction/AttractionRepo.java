package com.example.gp.Attraction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepo extends JpaRepository<Attraction,Long> {
    Attraction findById(int attractionId);
}

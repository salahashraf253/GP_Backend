package com.example.gp.Repository;

import com.example.gp.Model.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepo extends JpaRepository<Name,Long> {
}

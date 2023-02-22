package com.example.gp.Service;

import com.example.gp.Model.Name;
import com.example.gp.Repository.NameRepo;
import org.springframework.stereotype.Service;

@Service
public class NameService {
    private NameRepo nameRepo;

    public NameService(NameRepo nameRepo) {
        this.nameRepo = nameRepo;
    }

    public void saveName(Name name){
        nameRepo.save(name);
    }
}

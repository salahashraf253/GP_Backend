package com.example.gp.User.Name;

import org.springframework.stereotype.Service;

@Service
public class NameService {
    private NameRepo nameRepo;

    public NameService(NameRepo nameRepo) {
        this.nameRepo = nameRepo;
    }

    public void save(Name name) {
        nameRepo.save(name);
    }
}

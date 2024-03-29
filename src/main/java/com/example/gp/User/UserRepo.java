package com.example.gp.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findById(int id);
//    User update();

    User findByEmailAndPassword(String email, String password);

}

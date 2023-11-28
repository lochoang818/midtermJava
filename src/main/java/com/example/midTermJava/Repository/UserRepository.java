package com.example.midTermJava.Repository;

import com.example.midTermJava.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    public User findByEmail(String email);
    public Boolean existsByEmail(String username);

}

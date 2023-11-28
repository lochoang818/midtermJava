package com.example.midTermJava.Repository;

import com.example.midTermJava.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders,Integer> {
    @Query("SELECT o FROM Orders o WHERE o.user.email = :email AND o.status = 'Ordering'")
    public Optional<Orders> findOrdering(String email);
    @Query("SELECT COUNT(o) FROM Orders o WHERE o.user.User_id = :userId ")
    public int CountOrder(int userId);



}
package com.example.midTermJava.Repository;

import com.example.midTermJava.Model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoesRepository extends JpaRepository<Shoes, Integer> {

}

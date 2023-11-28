package com.example.midTermJava.Repository;

import com.example.midTermJava.Model.Color;
import com.example.midTermJava.Model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}

package com.example.midTermJava.Repository;

import com.example.midTermJava.Model.Category;
import com.example.midTermJava.Model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

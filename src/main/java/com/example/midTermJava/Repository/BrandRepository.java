package com.example.midTermJava.Repository;

import com.example.midTermJava.Model.Brand;
import com.example.midTermJava.Model.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}

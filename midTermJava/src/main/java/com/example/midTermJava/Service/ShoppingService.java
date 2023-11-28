package com.example.midTermJava.Service;

import com.example.midTermJava.Model.Brand;
import com.example.midTermJava.Model.Category;
import com.example.midTermJava.Model.Color;
import com.example.midTermJava.Model.Shoes;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShoppingService {
    public Optional<Shoes> findShoesById(int id);
    public List<Shoes> allShoes();
    public List<Category> allCategory();
    public List<Color> allColor();
    public List<Brand> allBrand();
    public List<Shoes> searchShoes(int brand, int cate, int color, int sort, int range);
//    public List<Shoes> searchShoesWithOutColor(int brand, int cate);
//    public List<Shoes> searchShoesWithOutCate(int brand, int color);
//    public List<Shoes> searchShoesWithOutBrand( int cate, int color);
//    public List<Shoes> searchShoes(int brand, int cate, int color);


}

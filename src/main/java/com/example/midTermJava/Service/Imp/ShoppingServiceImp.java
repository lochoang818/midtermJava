package com.example.midTermJava.Service.Imp;

import com.example.midTermJava.Model.Brand;
import com.example.midTermJava.Model.Category;
import com.example.midTermJava.Model.Color;
import com.example.midTermJava.Model.Shoes;
import com.example.midTermJava.Repository.BrandRepository;
import com.example.midTermJava.Repository.CategoryRepository;
import com.example.midTermJava.Repository.ColorRepository;
import com.example.midTermJava.Repository.ShoesRepository;
import com.example.midTermJava.Service.ShoppingService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShoppingServiceImp implements ShoppingService {
    @Autowired
    private ShoesRepository shoesRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Shoes> allShoes() {
        return shoesRepository.findAll();
    }

    @Override
    public List<Category> allCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public List<Color> allColor() {
        return colorRepository.findAll();
    }

    @Override
    public List<Brand> allBrand() {
        return brandRepository.findAll();
    }

    @Override
    public List<Shoes> searchShoes(int brand, int cate, int color, int sort, int range) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Shoes> query = builder.createQuery(Shoes.class);
        Root<Shoes> root = query.from(Shoes.class);

        List<Predicate> predicates = new ArrayList<>();

        if (brand != 0) {
            predicates.add(builder.equal(root.get("brand").get("brandId"), brand));
        }

        if (cate != 0) {
            predicates.add(builder.equal(root.get("category").get("cateId"), cate));
        }

        if (color != 0) {
            predicates.add(builder.equal(root.get("color").get("colorId"), color));
        }

        if (range == 1) {
            predicates.add(builder.between(root.get("price"), 10.0, 50.0));
        } else if (range == 2) {
            predicates.add(builder.between(root.get("price"), 50.0, 150.0));
        } else if (range == 3) {
            predicates.add(builder.greaterThan(root.get("price"), 150.0));
        }

        query.where(predicates.toArray(new Predicate[0]));




        if (sort == 0) {

            query.orderBy(builder.desc(root.get("name")));
        }
        if (sort == 1) {
            query.orderBy(builder.asc(root.get("name"))); // Thay "propertyName" bằng tên thuộc tính bạn muốn sắp xếp
        }
        else if(sort ==2) {
            query.orderBy(builder.desc(root.get("price"))); // Thay "propertyName" bằng tên thuộc tính bạn muốn sắp xếp
        }
        else if(sort ==3) {
            query.orderBy(builder.asc(root.get("price"))); // Thay "propertyName" bằng tên thuộc tính bạn muốn sắp xếp
        }
        return entityManager.createQuery(query).getResultList();
    }

    public Optional<Shoes> findShoesById(int id){
        return  this.shoesRepository.findById(id);
    }
}

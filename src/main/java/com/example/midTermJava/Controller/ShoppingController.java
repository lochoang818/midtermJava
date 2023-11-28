package com.example.midTermJava.Controller;

import com.example.midTermJava.Model.Brand;
import com.example.midTermJava.Model.Category;
import com.example.midTermJava.Model.Color;
import com.example.midTermJava.Model.Shoes;
import com.example.midTermJava.Service.Imp.ShoppingServiceImp;
import com.example.midTermJava.Service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/Shop")
public class ShoppingController {
    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/Menu")
    public ModelAndView shop(@RequestParam(value="brand", defaultValue = "0") int brand,
                             @RequestParam(value="cate", defaultValue = "0") int cate,
                             @RequestParam(value="color", defaultValue = "0") int color,
                             @RequestParam(value="sortBy", defaultValue = "0") int sortBy,
                             @RequestParam(value="rangePrice", defaultValue = "0") int rangePrice){
        ModelAndView modelAndView = new ModelAndView("Shopping/Shop");
        List<Shoes> shoesList = new ArrayList<>();
        List<Category> categories =shoppingService.allCategory();
        List<Color> colors = shoppingService.allColor();
        List<Brand> brands = shoppingService.allBrand();


        shoesList = shoppingService.searchShoes(brand,cate,color,sortBy,rangePrice);


        modelAndView.addObject("brand",brand);
        modelAndView.addObject("cate",cate);
        modelAndView.addObject("color",color);
        modelAndView.addObject("sort",sortBy);
        modelAndView.addObject("range",rangePrice);



        modelAndView.addObject("ShoesList",shoesList);
        modelAndView.addObject("categories",categories);
        modelAndView.addObject("brands",brands);
        modelAndView.addObject("colors",colors);

        return modelAndView;
    }
    @GetMapping("/api")
    public ResponseEntity getOrder(@RequestParam(value="brand", defaultValue = "0") int brand,
                                   @RequestParam(value="cate", defaultValue = "0") int cate,
                                   @RequestParam(value="color", defaultValue = "0") int color,
                                   @RequestParam(value="sortBy", defaultValue = "0") int sortBy,
                                   @RequestParam(value="rangePrice", defaultValue = "0") int rangePrice) {
        try {

            List<Shoes> shoesList = shoppingService.searchShoes(brand,cate,color,sortBy,rangePrice);
            return (ResponseEntity) ResponseEntity.ok(shoesList);


        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

}

package com.example.midTermJava.Controller;

import com.example.midTermJava.Dto.ShoesDto;
import com.example.midTermJava.Model.Orders;
import com.example.midTermJava.Model.Shoes;
import com.example.midTermJava.Model.ShoesOrder;
import com.example.midTermJava.Service.OrderService;
import com.example.midTermJava.Service.ShoppingService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    public OrderService orderService;
    @Autowired
    public ShoppingService shoppingService;
    @GetMapping("/AddToCart/{shoesId}")
    public ModelAndView addToCart(@PathVariable(name = "shoesId") Integer id,@RequestParam(value="quantity", defaultValue = "1") int quantity, HttpSession session){
        Optional<Shoes> shoes = this.shoppingService.findShoesById(id);
        String email = (String) session.getAttribute("email");

        this.orderService.insertCart(email);
        Optional<Orders> o = this.orderService.existOrdering(email);
        if(o.isPresent()){
            this.orderService.AddToCart(shoes.get(),o.get(),  quantity);

        }
        List<ShoesDto> shoesDtoList = this.orderService.listOrderItem(o.get().getOrder_id());
        ModelAndView modelAndView = new ModelAndView("Shopping/Cart");
        modelAndView.addObject("itemList",shoesDtoList);
        modelAndView.addObject("totalPrice",this.orderService.totalPriceCart(o.get()));
        return modelAndView;
    }
    public static  class ShoesRequest {
        public int shoesId;
        public ShoesRequest() {
            // Constructor không tham số
        }
        public ShoesRequest(int shoesId){
            this.shoesId = shoesId;
        }
        public int getShoesId() {
            return shoesId;
        }

        public void setShoesId(int shoesId) {
            this.shoesId = shoesId;
        }


    }
    @PostMapping("/IncreaseShoes")
    public ResponseEntity IncreaseShoes(@RequestBody ShoesRequest shoesRequest, HttpSession session){
//        String email="loc@gmail.com";
        String email = (String) session.getAttribute("email");
        Optional<Shoes> shoes = this.shoppingService.findShoesById(shoesRequest.shoesId);

        Optional<Orders> o = this.orderService.existOrdering(email);

        return (ResponseEntity) ResponseEntity.ok(this.orderService.IncreaseShoes(shoes.get(),o.get()));


    }
    @PostMapping("/DecreaseShoes")
    public ResponseEntity DecreaseShoes(@RequestBody ShoesRequest shoesRequest,HttpSession session){
        String email = (String) session.getAttribute("email");

        Optional<Shoes> shoes = this.shoppingService.findShoesById(shoesRequest.shoesId);

        Optional<Orders> o = this.orderService.existOrdering(email);

        return (ResponseEntity) ResponseEntity.ok(this.orderService.DecreaseShoes(shoes.get(),o.get()));

    }
    @GetMapping("/ShowCart")
    public ModelAndView index(HttpSession session){

        String email = (String) session.getAttribute("email");

        Optional<Orders> o = this.orderService.existOrdering(email);
        if(o.isEmpty()){
            return new ModelAndView("redirect:/Shop/Menu");

        }

        List<ShoesDto> shoesDtoList = this.orderService.listOrderItem(o.get().getOrder_id());
        ModelAndView modelAndView = new ModelAndView("Shopping/Cart");

        modelAndView.addObject("itemList",shoesDtoList);
        modelAndView.addObject("totalPrice",this.orderService.totalPriceCart(o.get()));
        return modelAndView;
    }
    @GetMapping("/Checkout")
    public ModelAndView checkout(HttpSession session){

        String email = (String) session.getAttribute("email");
        Optional<Orders> o = this.orderService.existOrdering(email);
        if(o.isEmpty()){
            return new ModelAndView("redirect:/Shop/Menu");

        }

//        List<ShoesDto> shoesDtoList = this.orderService.listOrderItem("loc@gmail.com1");
        List<ShoesDto> shoesDtoList = this.orderService.listOrderItem(o.get().getOrder_id());

        ModelAndView modelAndView = new ModelAndView("Shopping/checkout");
        modelAndView.addObject("itemList",shoesDtoList);
        modelAndView.addObject("infor",o.get());

        modelAndView.addObject("totalPrice",this.orderService.totalPriceCart(o.get()));
        return modelAndView;
    }
    @PostMapping("/completeCheckout")
    public ResponseEntity completeCheckout(@RequestBody Orders orders,HttpSession session){
        String email = (String) session.getAttribute("email");
        Optional<Orders> o = this.orderService.existOrdering(email);
        o.get().setPhone(orders.getPhone());
        o.get().setAddress(orders.getAddress());
        o.get().setTotalPrice(orders.getTotalPrice());
        o.get().setStatus("In Progress");
        return (ResponseEntity) ResponseEntity.ok(this.orderService.completeCheckout(o.get()));
    }
    @GetMapping("/detailProduct/{shoesId}")
    public ModelAndView detailProduct(@PathVariable(name = "shoesId") Integer id,HttpSession session){
        ModelAndView modelAndView = new ModelAndView("Shopping/single-product");
        Optional<Shoes> s = this.shoppingService.findShoesById(id);
        modelAndView.addObject("shoes",s.get());

        return modelAndView;
    }
}

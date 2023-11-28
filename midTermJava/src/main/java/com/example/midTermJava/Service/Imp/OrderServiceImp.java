package com.example.midTermJava.Service.Imp;

import com.example.midTermJava.Dto.ShoesDto;
import com.example.midTermJava.Model.*;
import com.example.midTermJava.Repository.OrderRepository;
import com.example.midTermJava.Repository.ShoesOrderRepository;
import com.example.midTermJava.Repository.UserRepository;
import com.example.midTermJava.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ShoesOrderRepository shoesOrderRepository;
    @Autowired
    UserRepository userRepository;

    public void AddToCart(Shoes shoes, Orders orders, int quantity){
        Optional<ShoesOrder> existing = shoesOrderRepository.existingOrder(orders.getOrder_id(),shoes.getShoesId());
        if(existing.isPresent()){
            ShoesOrder update =existing.get();
            update.setPrice(existing.get().getPrice()+ shoes.getPrice()*quantity);
            update.setQuantity(existing.get().getQuantity()+quantity);
            shoesOrderRepository.save(update);
        }
        else{
            ShoesOrder shoesOrder = new ShoesOrder();
            ShoesOrderKey key = new ShoesOrderKey();
            key.setOrderId(orders.getOrder_id());
            key.setShoesId(shoes.getShoesId());

            shoesOrder.setId(key);
            shoesOrder.setQuantity(quantity);
            shoesOrder.setPrice(shoes.getPrice()*quantity);
            shoesOrder.setOrder(orders);
            shoesOrder.setShoes(shoes);
            shoesOrderRepository.save(shoesOrder);

        }
    }

    @Override
    public Optional<Orders> existOrdering(String email) {
        return this.orderRepository.findOrdering(email);
    }

    @Override
    public List<ShoesDto> listOrderItem(String orderId) {
        return this.shoesOrderRepository.listOrderItem(orderId);
    }

    public void insertCart(String email){
        Optional<Orders> o = orderRepository.findOrdering(email);
        User u = userRepository.findByEmail(email);
        if(o.isEmpty()){
            int index = orderRepository.CountOrder(u.getUser_id()) +1;
            String newId =email  + index;
            Orders newOrder = new Orders();
            newOrder.setUser(u);
            newOrder.setOrder_id(newId);
            newOrder.setPhone(u.getPhone());
            newOrder.setStatus("Ordering");
            newOrder.setAddress(u.getAddress());
            newOrder.setTotalPrice(0);
            orderRepository.save(newOrder);
        }
    }
    public ShoesOrder DecreaseShoes(Shoes shoes, Orders orders){
        ShoesOrder shoesOrder = this.shoesOrderRepository.getItem(shoes.getShoesId(),orders.getOrder_id());
        shoesOrder.setQuantity(shoesOrder.getQuantity()-1);
        shoesOrder.setPrice(shoesOrder.getPrice()-shoes.getPrice());
        this.shoesOrderRepository.save(shoesOrder);
        return shoesOrder;
    }
    public ShoesOrder IncreaseShoes(Shoes shoes, Orders orders){
        ShoesOrder shoesOrder = this.shoesOrderRepository.getItem(shoes.getShoesId(),orders.getOrder_id());
        shoesOrder.setQuantity(shoesOrder.getQuantity()+1);
        shoesOrder.setPrice(shoesOrder.getPrice()+shoes.getPrice());
        this.shoesOrderRepository.save(shoesOrder);
        return shoesOrder;
    }
    public Double totalPriceCart(Orders orders){
        return this.shoesOrderRepository.totalPriceCart(orders.order_id);
    }

    @Override
    public Orders completeCheckout(Orders o) {
        this.orderRepository.save(o);
        return o;
    }
}

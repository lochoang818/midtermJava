package com.example.midTermJava.Service;

import com.example.midTermJava.Dto.ShoesDto;
import com.example.midTermJava.Model.Orders;
import com.example.midTermJava.Model.Shoes;
import com.example.midTermJava.Model.ShoesOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderService {
    public void insertCart(String email);
    public void AddToCart(Shoes shoes, Orders orders,int quantity);
    public Optional<Orders> existOrdering(String email);
    public List<ShoesDto> listOrderItem(String orderId);
    public ShoesOrder DecreaseShoes(Shoes shoes, Orders orders);
    public ShoesOrder IncreaseShoes(Shoes shoes, Orders orders);
    public Double totalPriceCart(Orders orders);
    public Orders completeCheckout(Orders o);

    }

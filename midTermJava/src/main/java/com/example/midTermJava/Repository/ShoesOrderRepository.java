package com.example.midTermJava.Repository;

import com.example.midTermJava.Dto.ShoesDto;
import com.example.midTermJava.Model.Orders;
import com.example.midTermJava.Model.Shoes;
import com.example.midTermJava.Model.ShoesOrder;
import com.example.midTermJava.Model.ShoesOrderKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShoesOrderRepository extends JpaRepository<ShoesOrder, ShoesOrderKey> {
    @Query("select o from ShoesOrder o where o.order.order_id like :order_id and o.shoes.shoesId = :shoes ")
    public Optional<ShoesOrder> existingOrder(String order_id, int shoes);
    @Query("select  new com.example.midTermJava.Dto.ShoesDto(s.shoes,s.price,s.quantity) from ShoesOrder s where s.order.order_id like :orderId ")
    public List<ShoesDto> listOrderItem(String orderId);

    @Query("select s from ShoesOrder  s where  s.shoes.shoesId = :shoesId and s.order.order_id like :orderId")
    public ShoesOrder getItem(int shoesId, String orderId);
    @Query("SELECT  sum(s.price) from ShoesOrder  s where s.order.order_id like :orderId")
    public Double totalPriceCart(String orderId);

    }

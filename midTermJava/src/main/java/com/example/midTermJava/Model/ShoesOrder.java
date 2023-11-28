package com.example.midTermJava.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class ShoesOrder {
    @EmbeddedId
    ShoesOrderKey id;
    @ManyToOne
    @MapsId("shoesId")
    @JoinColumn(name = "Shoes_id")
    Shoes shoes;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "Order_id")
    Orders order;

    int quantity;
    double price;
}

package com.example.midTermJava.Dto;

import com.example.midTermJava.Model.Shoes;
import lombok.Data;

@Data
public class ShoesDto {
    public Shoes shoes;
    public int quantity;
    public double price;

    public ShoesDto(Shoes shoes, double price, int quantity) {
        this.shoes = shoes;
        this.price = price;
        this.quantity = quantity;
    }
}

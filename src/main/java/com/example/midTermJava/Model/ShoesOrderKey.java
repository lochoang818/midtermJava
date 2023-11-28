package com.example.midTermJava.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ShoesOrderKey implements Serializable {
    @Column(name = "shoes_id")
    int shoesId;

    @Column(name = "order_id")
    String orderId;
}

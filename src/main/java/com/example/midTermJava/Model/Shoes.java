package com.example.midTermJava.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int shoesId;
    public String name;
    public String image;
    public double price;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "color")
    private Color color;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category")
    private Category category;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "brand")

    private Brand brand;

    @OneToMany(mappedBy = "shoes", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<ShoesOrder> shoesOrders;
}

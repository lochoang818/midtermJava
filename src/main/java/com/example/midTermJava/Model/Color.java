package com.example.midTermJava.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.*;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int colorId;
    public  String name;
    @JsonIgnore

    @OneToMany(mappedBy = "color", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Shoes> shoesList;
}

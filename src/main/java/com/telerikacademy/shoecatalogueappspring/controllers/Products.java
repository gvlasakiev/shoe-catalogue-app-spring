package com.telerikacademy.shoecatalogueappspring.controllers;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class Products {

    private List<Product> Product = new ArrayList<>();

    public void Product ()
    {
        List<Colors> colors = new ArrayList<>();
        colors.add(Colors.blue);
        colors.add(Colors.purple);
        colors.add(Colors.brown);
        Product.add(new Product("Nike", colors));
        Product.add(new Product("Adiddas", colors));
    }

    @GetMapping
    public Product getProduct() {
        List<Colors> colors = new ArrayList<>();
        colors.add(Colors.blue);
        colors.add(Colors.purple);
        colors.add(Colors.brown);
        Product.add(new Product("Nike", colors));
        return Product.get(0);
    }
}

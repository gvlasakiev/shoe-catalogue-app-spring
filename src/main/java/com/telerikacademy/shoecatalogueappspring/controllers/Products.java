package com.telerikacademy.shoecatalogueappspring.controllers;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import com.telerikacademy.shoecatalogueappspring.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class Products {

    private List<Product> Product = new ArrayList<>();

    private ProductService service;

    public Products (ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("getColors")
    public List<Colors> getProductColors() {
        return service.getProductColors();
    }
}

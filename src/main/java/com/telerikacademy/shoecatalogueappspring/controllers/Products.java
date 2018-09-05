package com.telerikacademy.shoecatalogueappspring.controllers;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import com.telerikacademy.shoecatalogueappspring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class Products {

    private ProductService service;

    public Products (ProductService service) {
        this.service = service;
    }

    @GetMapping
    public HashMap<Integer, Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("getColors")
    public List<Colors> getProductColors() {
        return service.getProductColors();
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
       return service.getProductById(id);
    }

}

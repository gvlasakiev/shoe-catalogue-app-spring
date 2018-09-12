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
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/colors")
    public List<Colors> getProductColors() {
        return service.getProductColors();
    }

    @GetMapping("/sizes")
    public List<Integer> getProductSizes() {
       return service.getProductSize();
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product) {
        service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@ PathVariable int id) {
       return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct (@PathVariable int id, @RequestBody Product product) {
        service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
    }


}

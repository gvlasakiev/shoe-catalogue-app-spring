package com.telerikacademy.shoecatalogueappspring.service;

import com.telerikacademy.shoecatalogueappspring.models.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    List<Product> getProducts();
    Product getProductById(int id);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
    void getProductColors();
    void getProductSize();
}

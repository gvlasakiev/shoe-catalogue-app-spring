package com.telerikacademy.shoecatalogueappspring.repository;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;

import java.util.List;

public interface ProductRepository {
    void createProduct(Product product);
    List<Product> getProducts();
    Product getProductById(int id);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
    List<Colors> getProductColors();
    void getProductSize();
}

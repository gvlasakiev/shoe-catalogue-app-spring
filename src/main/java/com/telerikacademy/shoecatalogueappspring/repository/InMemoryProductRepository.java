package com.telerikacademy.shoecatalogueappspring.repository;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> Product = new ArrayList<>();

    public InMemoryProductRepository() {
        List<Colors> colors = Arrays.asList(Colors.brown, Colors.purple, Colors.red);
        Product.add(new Product("Nike", colors));
        Product.add(new Product("Adiddas", colors));
    }

    @Override
    public void createProduct(Product product) {
        Product.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return Product;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void updateProduct(int id, Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public List<Colors> getProductColors() {
        List<Colors> colors = new ArrayList<>();
        Collections.addAll(colors, Colors.values());
        return colors;
    }

    @Override
    public void getProductSize() {

    }
}

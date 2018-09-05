package com.telerikacademy.shoecatalogueappspring.repository;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> Product = new ArrayList<>();

    public InMemoryProductRepository() {
        List<Colors> colors = new ArrayList<>();
        colors.add(Colors.blue);
        colors.add(Colors.purple);
        colors.add(Colors.brown);
        Product.add(new Product("Nike", colors));
        Product.add(new Product("Adiddas", colors));
    }

    @Override
    public void createProduct(Product product) {

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
    public void getProductColors() {

    }

    @Override
    public void getProductSize() {

    }
}

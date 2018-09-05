package com.telerikacademy.shoecatalogueappspring.repository;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.*;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    //Product.add(new Product("Nike", colors));

    //Product.add(new Product("Adiddas", colors));
    private HashMap<Integer, Product> Product = new HashMap<>();

    public InMemoryProductRepository() {
        List<Colors> colors = Arrays.asList(Colors.brown, Colors.purple, Colors.red);
        Product.put(0, new Product("Nike", colors));
        Product.put(1, new Product("Adiddas", colors));
    }

    @Override
    public void createProduct(Product product) {
        //Product.add(product);
        Product.put(product.getId(), product);
    }

    @Override
    public HashMap<Integer, Product> getProducts() {
        return Product;
    }

    @Override
    public Product getProductById(int id) {
       return Product.get(id);
    }

    @Override
    public void updateProduct(int id, Product product) {
        Product.put(id, product);
    }

    @Override
    public void deleteProduct(int id) {
        Product.remove(id);
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

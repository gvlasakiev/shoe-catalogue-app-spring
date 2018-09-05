package com.telerikacademy.shoecatalogueappspring.repository;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.*;
import java.util.List;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private static final int MIN_SHOE_SIZE = 35;
    private static final int MAX_SHOE_SIZE = 46;

    private HashMap<Integer, Product> Product = new HashMap<>();

    public InMemoryProductRepository() {
        List<Colors> colors = Arrays.asList(Colors.brown, Colors.purple, Colors.red);
        List<Integer> size1 = Arrays.asList(43,42,40,38);
        List<Integer> size2 = Arrays.asList(36,37,39);
        Product.put(0, new Product("Nike", colors, size1));
        Product.put(1, new Product("Adiddas", colors, size2));
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
    public List<Integer> getProductSize() {
        List<Integer> productSize= new ArrayList<>();
        for (int a = MIN_SHOE_SIZE; a <= MAX_SHOE_SIZE ; a++) {
            productSize.add(a);
        }
        return productSize;
    }
}

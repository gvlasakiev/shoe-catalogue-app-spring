package com.telerikacademy.shoecatalogueappspring.service;

import com.telerikacademy.shoecatalogueappspring.models.Product;
import com.telerikacademy.shoecatalogueappspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createProduct(Product product) {
        repository.createProduct(product);
    }

    @Override
    public List<Product> getProducts() {
        return repository.getProducts();
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

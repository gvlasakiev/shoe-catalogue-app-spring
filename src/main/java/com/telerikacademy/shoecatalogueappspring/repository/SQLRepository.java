package com.telerikacademy.shoecatalogueappspring.repository;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

public class SQLRepository implements ProductRepository{
    private String dbUrl, username, password;

    @Autowired
    public SQLRepository(Environment env){
        dbUrl = env.getProperty("database.url");
        username = env.getProperty("database.username");
        password = env.getProperty("database.password");
    }


    @Override
    public void createProduct(Product product) {

    }

    @Override
    public List<Product> getProducts() {
        String query = "select * from shoes";
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            products = readData(resultSet);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return products;
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
        return null;
    }

    @Override
    public List<Integer> getProductSize() {
        return null;
    }

    private List<Product> readData(ResultSet productsData) throws SQLException {
        List<Product> products = new ArrayList<>();
        while (productsData.next()){
            Product p = new Product();
            p.setId(productsData.getInt("ShoeID"));
            p.setName(productsData.getString("Name"));
            p.setModel(productsData.getString("Model"));
            p.setDescription(productsData.getString("Description"));
            p.setPrice(productsData.getInt("price"));
            products.add(p);
        }
        return products;
    }
}

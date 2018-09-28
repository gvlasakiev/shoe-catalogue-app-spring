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
        String query = "select * from shoes where shoes.ShoeID = " + id + ";";
        Product product = new Product();
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            product = readProductById(resultSet);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return product;
    }


    @Override
    public void updateProduct(int id, Product product) {

    }

    @Override
    public void deleteProduct(int id) {

    }

    @Override
    public List<String> getProductColors() {
        String query = "select c.Name from colors as c";
        List<String> colors = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            colors = readColors(resultSet);
        } catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return colors;
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

    private Product readProductById(ResultSet productsData) throws SQLException {
        Product product = new Product();
        productsData.next();
        product.setId(productsData.getInt("ShoeID"));
        product.setName(productsData.getString("Name"));
        product.setModel(productsData.getString("Model"));
        product.setDescription(productsData.getString("Description"));
        product.setPrice(productsData.getInt("price"));
        return product;
    }

    private List<String> readColors(ResultSet resultSet) throws SQLException {
        List<String> colors = new ArrayList<>();
        while(resultSet.next()){
            colors.add(resultSet.getString("Name"));
        }
        return colors;
    }
}

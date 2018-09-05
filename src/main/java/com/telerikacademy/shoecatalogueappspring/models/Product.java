package com.telerikacademy.shoecatalogueappspring.models;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private static int id;

    private String name, model, description, imagePath;
    private int price;
    private List<Colors> Colors;

    public Product() {

    }

    public Product(String name, List<Colors> colors) {
        Colors = colors;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Colors> getColors() {
        return Colors;
    }

    public void setColors(List<Colors> colors) {
        Colors = colors;
    }

}

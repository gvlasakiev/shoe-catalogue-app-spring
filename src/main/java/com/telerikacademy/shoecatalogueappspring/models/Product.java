package com.telerikacademy.shoecatalogueappspring.models;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private static int count = 0;
    private final int id;
    private String name, model, description, imagePath;
    private int price;
    private List<Colors> colors;
    private List<Integer> sizes;

    public Product() {
        this.id = count++;
    }

    public Product(String name, List<Colors> colors, List<Integer> sizes) {
        this.colors = colors;
        this.name = name;
        this.id = count++;
        this.sizes = sizes;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Colors> getColors() {
        return colors;
    }

    public void setColors(List<Colors> colors) {
        this.colors = colors;
    }

    public List<Integer> getSizes() {
        return sizes;
    }

    public void setSizes(List<Integer> sizes) {
        this.sizes = sizes;
    }

}

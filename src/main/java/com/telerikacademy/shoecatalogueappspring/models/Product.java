package com.telerikacademy.shoecatalogueappspring.models;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private static int count = 0;
    private int id;
    private String name, model, description, imagePath;
    private int price;
    private List<Colors> Colors;
    private List<Integer> Sizes;

    public Product() {
        this.id = count++;
    }

    public Product(String name, List<Colors> colors, List<Integer> sizes) {
        Colors = colors;
        this.name = name;
        this.id = count++;
        Sizes = sizes;
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
        return Colors;
    }

    public void setColors(List<Colors> colors) {
        Colors = colors;
    }

    public List<Integer> getSizes() {
        return Sizes;
    }

    public void setSizes(List<Integer> sizes) {
        Sizes = sizes;
    }

}

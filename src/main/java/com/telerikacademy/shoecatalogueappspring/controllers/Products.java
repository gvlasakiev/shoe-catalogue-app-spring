package com.telerikacademy.shoecatalogueappspring.controllers;

import com.telerikacademy.shoecatalogueappspring.models.Colors;
import com.telerikacademy.shoecatalogueappspring.models.Product;
import com.telerikacademy.shoecatalogueappspring.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class Products {

    private ProductService service;

    public Products (ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getProducts(HttpServletRequest request) {
        Date date = new Date();
        System.out.println("New Get Request: All products Requested at " + date + "; IP: " + request.getRemoteAddr());
        return service.getProducts();
    }

    @GetMapping("/colors")
    public List<String> getProductColors(HttpServletRequest request) {
        Date date = new Date();
        System.out.println("New Get Request: Colors Requested at " + date + "; IP: " + request.getRemoteAddr());
        return service.getProductColors();
    }

    @GetMapping("/sizes")
    public List<Integer> getProductSizes(HttpServletRequest request) {
        Date date = new Date();
        System.out.println("New Get Request: Sizes Requested at " + date + "; IP: " + request.getRemoteAddr());
        return service.getProductSize();
    }

    @PostMapping("/create")
    public void createProduct(@RequestBody Product product, HttpServletRequest request) {
        Date date = new Date();
        System.out.println("New Post Request: Create Product Requested at " + date + "; IP: " + request.getRemoteAddr());
        service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@ PathVariable int id, HttpServletRequest request) {
        Date date = new Date();
        System.out.println("New Get Request: Product with ID " + id + " Requested at " + date + "; IP: " + request.getRemoteAddr());
        return service.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct (@PathVariable int id, @RequestBody Product product, HttpServletRequest request) {
        Date date = new Date();
        System.out.println("New Put Request: Update on product with ID " + id + " Requested at " + date + "; IP: " + request.getRemoteAddr());
        service.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id, HttpServletRequest request) {
        Date date = new Date();
        System.out.println("New DELETE Request: Delete on product with ID + " + id + " Requested at " + date + "; IP: " + request.getRemoteAddr());
        service.deleteProduct(id);
    }

}

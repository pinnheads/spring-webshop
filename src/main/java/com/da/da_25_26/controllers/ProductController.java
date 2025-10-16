package com.da.da_25_26.controllers;

import com.da.da_25_26.models.Product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProductController {

  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return Product.getProducts();
  }

  @GetMapping("/products/{reqId}")
  public Optional<Product> getProductWithId(@PathVariable long reqId) {
    Optional<Product> product = Product.getProducts().stream()
        .filter(item -> item.getId() == reqId)
        .findFirst();
    return product;
  }

  @GetMapping("/products/color/{color}")
  public List<Product> getProductsWithColor(@PathVariable String color) {
    List<Product> colorProducts = Product.getProducts().stream()
        .filter(product -> product.getColor().equalsIgnoreCase(color))
        .collect(Collectors.toList());
    return colorProducts;
  }
}

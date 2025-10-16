package com.da.da_25_26;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Product {

  // private attributes for the Objects
  private long id;
  private String name;
  private double price;
  private String size;
  private String color;

  // static list
  private static final List<Product> productList = new ArrayList<>();

  // add items
  static {
    productList.add(new Product(1L, "Classic T-Shirt", 19.99, "M", "White"));
    productList.add(new Product(2L, "Running Shoes", 89.50, "43", "Black"));
    productList.add(new Product(3L, "Denim Jeans", 75.00, "32/34", "Blue"));
    productList.add(new Product(4L, "Wool Scarf", 25.00, "One Size", "Gray"));
    productList.add(new Product(5L, "Leather Belt", 45.99, "L", "Brown"));
  }

  // constructor class
  public Product(long id, String name, double price, String size, String color) {
    this.id = id;
    this.name = name;
    this.price = price;
    this.size = size;
    this.color = color;
  }

  // Getters and Setters for the private attributes
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  // get products
  public static List<Product> getProducts() {
    return productList;
  }
}

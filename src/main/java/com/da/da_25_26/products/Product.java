package com.da.da_25_26.products;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Product.fetchAllBlue", query = "SELECT p FROM Product p WHERE p.color = 'Blue'")
@NamedQuery(name = "Product.fetchAllBlack", query = "SELECT p FROM  Product p WHERE p.color = 'Black'")
@NamedQuery(name = "Product.fetchAllBrown", query = "SELECT p FROM Product p WHERE p.color = 'Brown'")
@NamedQuery(name = "Product.fetchAllGray", query = "SELECT p FROM Product p WHERE p.color = 'Gray'")
public class Product {

  @Id
  @GeneratedValue
  private long id;

  private String name;
  private double price;
  private String size;
  private String color;

  Product(String name, double price, String size, String color) {
    this.name = name;
    this.price = price;
    this.size = size;
    this.color = color;
  }

  public Product() {

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
}

package com.da.da_25_26.cart;

import java.util.HashMap;
import java.util.Map;

import com.da.da_25_26.products.Product;

public class ShoppingCart {
  public Map<Product, Integer> products = new HashMap<>();

  public void addProduct(Product product) {
    if (products.containsKey(product)) {
      products.put(product, products.get(product) + 1);
    } else {
      products.put(product, 1);
    }
  }

  public void removeProduct(Product product) {
    products.remove(product);
  }

  public Double getTotal() {
    return products.entrySet().stream()
        .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
        .sum();
  }
}

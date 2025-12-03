package com.da.da_25_26.cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.da.da_25_26.products.Product;

public class ShoppingCart {
  public Map<Product, Integer> products = new HashMap<>();

  public void addProduct(Product product) {
    Product keyInMap = products.keySet().stream()
        .filter(p -> p.getId() == product.getId())
        .findFirst().orElse(null);
    if (keyInMap != null) {
      products.put(keyInMap, products.get(keyInMap) + 1);
    } else {
      products.put(product, 1);
    }
  }

  public void removeProduct(Product product) {
    Product keyInMap = products.keySet().stream()
        .filter(p -> p.getId() == product.getId())
        .findFirst().orElse(null);
    if (keyInMap != null) {
      int currentQuantity = products.get(keyInMap);
      if (currentQuantity > 1) {
        products.put(keyInMap, products.get(keyInMap) - 1);
      } else {
        products.remove(keyInMap);
      }
    }
  }

  public BigDecimal getTotal() {
    return products.entrySet().stream()
        .map(entry -> {
          BigDecimal price = entry.getKey().getPrice();
          BigDecimal quantity = BigDecimal.valueOf(entry.getValue());
          return price.multiply(quantity);
        })
        .reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}

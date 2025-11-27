package com.da.da_25_26.products.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.da.da_25_26.products.Product;
import com.da.da_25_26.products.ProductRepository;

@Service
public class InventoryService {
  private final Map<Long, Integer> inventory = new HashMap<>();

  public InventoryService(ProductRepository repository) {
    List<Product> allProducts = repository.findAll();
    for (Product product : allProducts) {
      inventory.put(product.getId(), (int) (Math.random() * 50) + 1);
    }
  }

  public int getStockForProductId(Long productId) {
    return inventory.getOrDefault(productId, 0);
  }

  public boolean increaseStockForProductIdByOne(Long productId) {
    return increaseStockForProductId(productId, 1);
  }

  public boolean increaseStockForProductId(Long productId, int quantity) {
    int currentStock = getStockForProductId(productId);
    inventory.put(productId, currentStock + quantity);
    return true;
  }

  public boolean reduceStockForProductIdByOne(Long productId) {
    return reduceStockForProductId(productId, 1);
  }

  public boolean reduceStockForProductId(Long productId, int quantity) {
    int currentStock = getStockForProductId(productId);

    if (currentStock >= quantity) {
      inventory.put(productId, currentStock - quantity);
      return true;
    }

    return false;
  }
}

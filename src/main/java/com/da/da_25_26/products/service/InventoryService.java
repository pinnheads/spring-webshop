package com.da.da_25_26.products.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {
  private final Map<Long, Integer> inventory = new HashMap<>();

  public InventoryService() {
    inventory.put(1L, 10);
    inventory.put(2L, 30);
    inventory.put(3L, 40);
    inventory.put(4L, 20);
    inventory.put(5L, 60);
  }

  public int getStockForProductId(Long productId) {
    return inventory.getOrDefault(productId, 0);
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

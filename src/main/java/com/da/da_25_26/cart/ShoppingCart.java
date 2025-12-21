package com.da.da_25_26.cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.da.da_25_26.products.PriceCalculationService;
import com.da.da_25_26.products.Product;

public class ShoppingCart {
  public Map<Product, Integer> products = new HashMap<>();

  private final PriceCalculationService priceCalculationService = new PriceCalculationService();
  private boolean voucherApplied = false;
  private BigDecimal originalTotalPrice;
  private BigDecimal cartTotal = BigDecimal.valueOf(1.00);

  public boolean isVoucherApplied() {
    return this.voucherApplied;
  }

  public void setVoucherApplied(boolean voucherApplied) {
    this.voucherApplied = voucherApplied;
  }

  public BigDecimal getOriginalTotalPrice() {
    return this.originalTotalPrice;
  }

  public void setOriginalTotalPrice(BigDecimal originalTotalPrice) {
    this.originalTotalPrice = originalTotalPrice;
  }

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

  public Map<Product, Integer> getProducts() {
    return this.products;
  }

  public BigDecimal getTotal() {
    return this.cartTotal;
  }

  public void setTotal(BigDecimal total) {
    cartTotal = total;
  }
}

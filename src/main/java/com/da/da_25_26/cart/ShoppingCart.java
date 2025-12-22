package com.da.da_25_26.cart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.da.da_25_26.products.Product;
import com.da.da_25_26.products.PriceCalculationService.Currency;

public class ShoppingCart {
  public Map<Product, Integer> products = new HashMap<>();

  private boolean voucherApplied = false;
  private Currency currentCurrency = Currency.EURO;
  private BigDecimal originalTotalPrice;
  private BigDecimal cartTotal = BigDecimal.valueOf(0.00);

  public boolean isVoucherApplied() {
    return this.voucherApplied;
  }

  public void setVoucherApplied(boolean voucherApplied) {
    this.voucherApplied = voucherApplied;
  }

  public Currency getCurrentCurrency() {
    return currentCurrency;
  }

  public void setCurrentCurrency(Currency currentCurrency) {
    this.currentCurrency = currentCurrency;
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

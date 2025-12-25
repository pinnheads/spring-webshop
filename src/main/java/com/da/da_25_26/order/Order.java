package com.da.da_25_26.order;

import java.math.BigDecimal;

public class Order {
  private Long id;
  private Long userId;
  private BigDecimal totalPrice;

  public Order(Long userId, BigDecimal totalPrice) {
    this.userId = userId;
    this.totalPrice = totalPrice;
    this.id = (long) (Math.random() * 10000);
  }

  public Long getId() {
    return id;
  }

  public Long getUserId() {
    return userId;
  }

  public BigDecimal totalPrice() {
    return totalPrice;
  }
}

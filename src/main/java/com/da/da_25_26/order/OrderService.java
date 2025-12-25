package com.da.da_25_26.order;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class OrderService {
  public Order finalizeOrder(Long userId, BigDecimal totalPrice) {
    return new Order(userId, totalPrice);
  }
}

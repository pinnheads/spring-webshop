package com.da.da_25_26.order;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.da.da_25_26.users.UserService;

@Service
public class OrderFacade {
  private final OrderService orderService;
  private final UserService userService;

  public OrderFacade(OrderService orderService, UserService userService) {
    this.orderService = orderService;
    this.userService = userService;
  }

  public Order finalizeOrder(BigDecimal totalPrice) {
    Long userId = userService.getUserId();
    return orderService.finalizeOrder(userId, totalPrice);
  }
}

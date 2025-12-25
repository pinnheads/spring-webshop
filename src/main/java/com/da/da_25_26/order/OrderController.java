package com.da.da_25_26.order;

import java.math.BigDecimal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {
  private final OrderFacade orderFacade;

  public OrderController(OrderFacade orderFacade) {
    this.orderFacade = orderFacade;
  }

  @PostMapping("/checkout")
  public String checkout(@RequestParam BigDecimal totalPrice, Model model) {
    Order order = orderFacade.finalizeOrder(totalPrice);
    model.addAttribute("order", order);
    return "order-success";
  }
}

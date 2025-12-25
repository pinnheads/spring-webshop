package com.da.da_25_26.order;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@Service
public class OrderAdapter {
  private final OrderFacade orderFacade;
  private final EMailService eMailService;

  public OrderAdapter(OrderFacade orderFacade, EMailService eMailService) {
    this.orderFacade = orderFacade;
    this.eMailService = eMailService;
  }

  public Order finalizeOrder(BigDecimal totalPrice) {
    Order order = orderFacade.finalizeOrder(totalPrice);
    Long userId = order.getUserId();
    eMailService.sendEmail(userId);

    return order;
  }
}

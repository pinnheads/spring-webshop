package com.da.da_25_26.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.da_25_26.products.service.InventoryService;

@Service
public class ShoppingCartFacade {
  private IShoppingCartService shoppingCartService;
  private InventoryService inventoryService;

  @Autowired
  public ShoppingCartFacade(IShoppingCartService shoppingCartService, InventoryService inventoryService) {
    this.shoppingCartService = shoppingCartService;
    this.inventoryService = inventoryService;
  }

  public ShoppingCart getCart() {
    return shoppingCartService.getShoppingCart();
  }

  public ShoppingCart addProductToCart(Long id) {
    if (inventoryService.getStockForProductId(id) > 0) {
      shoppingCartService.addProductToCart(id);
    } else {
      throw new RuntimeException("Product is out of stock! ID: " + id);
    }

    return shoppingCartService.getShoppingCart();
  }

  public void removeProductFromCart(Long id) {
    shoppingCartService.removeProductFromCart(id);
  }
}

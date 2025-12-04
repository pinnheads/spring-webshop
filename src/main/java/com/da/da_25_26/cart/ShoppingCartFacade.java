package com.da.da_25_26.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.da_25_26.products.service.InventoryService;

/**
 * **Purpose**
 * Facade service the coordinates interaction between the shopping cart and
 * inventroy service.
 *
 * **Requirements**
 * {@link IShoppingCartService}: Manages the session related cart instance.
 * {@link InventoryService}: Manages the stock levels.
 *
 * **Capabilities**
 * Retrieves the current state of the user's shoppping cart
 * addition of items - decrements inventory, updates cart
 * removal of items - increments inventory, updates cart
 */
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
      inventoryService.reduceStockForProductIdByOne(id);
      shoppingCartService.addProductToCart(id);
    } else {
      throw new RuntimeException("Product is out of stock! ID: " + id);
    }

    return shoppingCartService.getShoppingCart();
  }

  public void removeProductFromCart(Long id) {
    inventoryService.increaseStockForProductIdByOne(id);
    shoppingCartService.removeProductFromCart(id);
  }
}

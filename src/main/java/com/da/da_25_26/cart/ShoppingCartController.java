package com.da.da_25_26.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.da.da_25_26.products.service.InventoryService;

@Controller
@RequestMapping("/api/cart")
public class ShoppingCartController {

  private IShoppingCartService shoppingCartService;
  private InventoryService inventoryService;

  @Autowired
  public ShoppingCartController(IShoppingCartService shoppingCartService, InventoryService inventoryService) {
    this.shoppingCartService = shoppingCartService;
    this.inventoryService = inventoryService;
  }

  @GetMapping("")
  public String getShoppingCart(Model model) {
    model.addAttribute("cart", shoppingCartService.getShoppingCart());
    return "cart";
  }

  @GetMapping("/add/{id}")
  public String addProductToCart(@PathVariable long id, Model model) {
    shoppingCartService.addProductToCart(id);
    inventoryService.reduceStockForProductIdByOne(id);
    return "redirect:/api/cart";
  }

  @GetMapping("/delete/{id}")
  public String removeProductToCart(@PathVariable long id, Model model) {
    shoppingCartService.removeProductFromCart(id);
    return "redirect:/api/cart";
  }
}

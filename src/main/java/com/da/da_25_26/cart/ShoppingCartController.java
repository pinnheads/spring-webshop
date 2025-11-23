package com.da.da_25_26.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController
@Controller
@RequestMapping("/api/cart")
public class ShoppingCartController {

  private IShoppingCartService shoppingCartService;

  @Autowired
  public ShoppingCartController(IShoppingCartService shoppingCartService) {
    this.shoppingCartService = shoppingCartService;
  }

  @GetMapping("")
  public String getShoppingCart(Model model) {
    model.addAttribute("cart", shoppingCartService.getShoppingCart());
    return "cart";
  }

  // @GetMapping("/view")
  // public ShoppingCart getCart() {
  // return shoppingCartService.getShoppingCart();
  // }

  @GetMapping("/add/{id}")
  public String addProductToCart(@PathVariable long id, Model model) {
    shoppingCartService.addProductToCart(id);
    return "redirect:/api/cart";
  }

  @GetMapping("/delete/{id}")
  public String removeProductToCart(@PathVariable long id, Model model) {
    shoppingCartService.removeProductFromCart(id);
    return "redirect:/api/cart";
  }
}

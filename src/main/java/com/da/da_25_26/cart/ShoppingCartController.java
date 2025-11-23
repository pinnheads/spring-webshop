package com.da.da_25_26.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/cart")
public class ShoppingCartController {

  private ShoppingCartFacade shoppingCartFacade;

  @Autowired
  public ShoppingCartController(ShoppingCartFacade shoppingCartFacade) {
    this.shoppingCartFacade = shoppingCartFacade;
  }

  @GetMapping("")
  public String getShoppingCart(Model model) {
    model.addAttribute("cart", shoppingCartFacade.getCart());
    return "cart";
  }

  @GetMapping("/add/{id}")
  public String addProductToCart(@PathVariable long id) {
    try {
      shoppingCartFacade.addProductToCart(id);
      return "redirect:/api/cart";
    } catch (Exception e) {
      return "redirect:/api/cart";
    }
  }

  @GetMapping("/delete/{id}")
  public String removeProductToCart(@PathVariable long id) {
    shoppingCartFacade.removeProductFromCart(id);
    return "redirect:/api/cart";
  }
}

package com.da.da_25_26.cart;

public interface IShoppingCartService {
  ShoppingCart getShoppingCart();

  void addProductToCart(Long productId);

  void removeProductFromCart(Long productId);
}

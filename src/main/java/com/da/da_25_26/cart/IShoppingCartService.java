package com.da.da_25_26.cart;

public interface IShoppingCartService {
  int getVoucherPercentage();

  void applyVoucher();

  void removeVoucher();

  String getCurrency();

  void setCurrency(String currency);

  ShoppingCart getShoppingCart();

  void addProductToCart(Long productId);

  void removeProductFromCart(Long productId);
}

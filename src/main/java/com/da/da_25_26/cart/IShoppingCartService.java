package com.da.da_25_26.cart;

import com.da.da_25_26.products.PriceCalculationService.Currency;

public interface IShoppingCartService {
  int getVoucherPercentage();

  void applyVoucher();

  void removeVoucher();

  Currency getCurrency();

  void setCurrency(String currency);

  ShoppingCart getShoppingCart();

  void addProductToCart(Long productId);

  void removeProductFromCart(Long productId);
}

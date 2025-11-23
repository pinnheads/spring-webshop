package com.da.da_25_26.cart;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.da_25_26.products.IProductService;
import com.da.da_25_26.products.Product;

@Service
public class ShoppingCartService implements IShoppingCartService {
  private final ShoppingCart shoppingCart;
  private final IProductService productService;

  @Autowired
  public ShoppingCartService(IProductService productService) {
    this.productService = productService;
    this.shoppingCart = new ShoppingCart();
  }

  public ShoppingCart getShoppingCart() {
    return shoppingCart;
  }

  public void addProductToCart(Long productId) {
    Optional<Product> productOpt = productService.getSingleProduct(productId);
    if (productOpt.isPresent()) {
      this.shoppingCart.addProduct(productOpt.get());
    }
  }

  public void removeProductFromCart(Long productId) {
    Optional<Product> productOpt = productService.getSingleProduct(productId);
    productOpt.ifPresent(product -> shoppingCart.removeProduct(product));
  }
}

package com.da.da_25_26.cart;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.da_25_26.products.IProductService;
import com.da.da_25_26.products.PriceCalculationService;
import com.da.da_25_26.products.Product;

@Service
public class ShoppingCartService implements IShoppingCartService {
  private final ShoppingCart shoppingCart;
  private final IProductService productService;
  private final PriceCalculationService priceCalculationService;

  @Autowired
  public ShoppingCartService(IProductService productService, PriceCalculationService priceCalculationService) {
    this.productService = productService;
    this.shoppingCart = new ShoppingCart();
    this.priceCalculationService = priceCalculationService;
  }

  public int getVoucherPercentage() {
    return this.priceCalculationService.getVoucherPercentage();
  }

  public void applyVoucher() {
    if (!this.shoppingCart.isVoucherApplied()) {
      shoppingCart.setVoucherApplied(true);
      refershTotals();
    }
  }

  public void removeVoucher() {
    if (this.shoppingCart.isVoucherApplied()) {
      shoppingCart.setVoucherApplied(false);
      refershTotals();
    }
  }

  public ShoppingCart getShoppingCart() {
    return this.shoppingCart;
  }

  public void refershTotals() {
    BigDecimal rawTotal = this.shoppingCart.getProducts().entrySet().stream()
        .map(entry -> {
          BigDecimal price = priceCalculationService.roundPrice(entry.getKey().getPrice());
          BigDecimal quantity = BigDecimal.valueOf(entry.getValue());
          return price.multiply(quantity);
        }).reduce(BigDecimal.ZERO, BigDecimal::add);

    if (this.shoppingCart.isVoucherApplied()) {
      shoppingCart.setOriginalTotalPrice(rawTotal);
      BigDecimal discountedTotal = priceCalculationService.applyVoucher(rawTotal);
      shoppingCart.setTotal(discountedTotal);
    } else {
      shoppingCart.setTotal(rawTotal);
      shoppingCart.setOriginalTotalPrice(null);
    }
  }

  public void addProductToCart(Long productId) {
    Optional<Product> productOpt = productService.getSingleProduct(productId);
    if (productOpt.isPresent()) {
      this.shoppingCart.addProduct(productOpt.get());
      refershTotals();
    }
  }

  public void removeProductFromCart(Long productId) {
    Optional<Product> productOpt = productService.getSingleProduct(productId);
    productOpt.ifPresent(product -> shoppingCart.removeProduct(product));
    refershTotals();
  }
}

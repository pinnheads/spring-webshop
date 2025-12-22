package com.da.da_25_26.cart;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.da_25_26.products.IProductService;
import com.da.da_25_26.products.PriceCalculationService;
import com.da.da_25_26.products.Product;
import com.da.da_25_26.products.PriceCalculationService.Currency;

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

  public Currency getCurrency() {
    if (shoppingCart.getCurrentCurrency() != null) {
      return shoppingCart.getCurrentCurrency();
    }
    return priceCalculationService.getDefaultCurrency();
  }

  public void setCurrency(String currency) {
    try {
      Currency newCurrency = Currency.valueOf(currency);
      shoppingCart.setCurrentCurrency(newCurrency);
      refershTotals();
    } catch (IllegalArgumentException e) {
      System.err.println("Invalid Currency: " + currency);
    }
  }

  public ShoppingCart getShoppingCart() {
    return this.shoppingCart;
  }

  public void refershTotals() {
    BigDecimal rawTotalEur = this.shoppingCart.getProducts().entrySet().stream()
        .map(entry -> {
          BigDecimal price = entry.getKey().getPrice();
          BigDecimal quantity = BigDecimal.valueOf(entry.getValue());
          return price.multiply(quantity);
        }).reduce(BigDecimal.ZERO, BigDecimal::add);

    BigDecimal finalTotalEur;

    if (this.shoppingCart.isVoucherApplied()) {
      shoppingCart.setOriginalTotalPrice(rawTotalEur); // Temp store as Euro
      finalTotalEur = priceCalculationService.applyVoucher(rawTotalEur);
    } else {
      shoppingCart.setOriginalTotalPrice(null);
      finalTotalEur = rawTotalEur;
    }

    Currency targetCurrency = shoppingCart.getCurrentCurrency();

    BigDecimal convertedTotal = priceCalculationService.convertToCurrency(
        finalTotalEur, Currency.EURO, targetCurrency);
    shoppingCart.setTotal(convertedTotal);

    if (shoppingCart.getOriginalTotalPrice() != null) {
      BigDecimal convertedOriginal = priceCalculationService.convertToCurrency(
          shoppingCart.getOriginalTotalPrice(), Currency.EURO, targetCurrency);
      shoppingCart.setOriginalTotalPrice(priceCalculationService.roundPrice(convertedOriginal));
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

package com.da.da_25_26.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Rounds prices upto 2 decimal places
 * 
 * @param price - The raw price value
 * @return - The rounded BigDecimal Value
 */
@Service
public class PriceCalculationService {

  public enum Currency {
    EURO,
    DOLLAR
  }

  private final BigDecimal eurToDollarRate = BigDecimal.valueOf(1.17);
  private final BigDecimal dollarToEurRate = BigDecimal.valueOf(0.85);
  private final BigDecimal VOUCHER_DISCOUNT_PERCENTAGE;

  private static final int digits = 2;
  private final String defaultCurrency;

  public PriceCalculationService(@Value("${app.currency.default}") String defaultCurrency,
      @Value("${app.discount.percentage:0.10}") double discountPercentage) {
    this.defaultCurrency = defaultCurrency;
    this.VOUCHER_DISCOUNT_PERCENTAGE = BigDecimal.valueOf(discountPercentage);
  }

  public Currency getDefaultCurrency() {
    return Currency.valueOf(this.defaultCurrency);
  }

  public BigDecimal roundPrice(BigDecimal price) {
    if (price == null) {
      return BigDecimal.ZERO;
    }

    return price.setScale(digits, RoundingMode.HALF_UP);
  }

  public BigDecimal roundPrice(double price) {
    return roundPrice(BigDecimal.valueOf(price));
  }

  public BigDecimal convertToCurrency(BigDecimal amount, Currency fromCurrency, Currency toCurrency) {
    if (amount == null)
      return BigDecimal.ZERO;

    if (fromCurrency == toCurrency) {
      return roundPrice(amount);
    }

    if (fromCurrency == Currency.EURO && toCurrency == Currency.DOLLAR) {
      return roundPrice(amount.multiply(eurToDollarRate));
    } else if (fromCurrency == Currency.DOLLAR && toCurrency == Currency.EURO) {
      return roundPrice(amount.multiply(dollarToEurRate));
    }

    return roundPrice(amount);
  }

  public BigDecimal applyVoucher(BigDecimal currentTotal) {
    BigDecimal discount = currentTotal.multiply(VOUCHER_DISCOUNT_PERCENTAGE);
    return roundPrice(currentTotal.subtract(discount));
  }

  public int getVoucherPercentage() {
    return VOUCHER_DISCOUNT_PERCENTAGE.multiply(new BigDecimal("100")).intValue();
  }
}

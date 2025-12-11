package com.da.da_25_26.products;

import java.math.BigDecimal;
import java.math.RoundingMode;

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

  private static final int digits = 2;

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
    if (fromCurrency == Currency.EURO) {
      return amount.multiply(eurToDollarRate);
    } else {
      return amount.multiply(dollarToEurRate);
    }
  }

  public BigDecimal applyVoucher(BigDecimal amount, BigDecimal percentageVoucher) {
    return amount.multiply(percentageVoucher.divide(BigDecimal.valueOf(100.00)));
  }
}

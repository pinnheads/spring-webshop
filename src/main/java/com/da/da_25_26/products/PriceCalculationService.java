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
}

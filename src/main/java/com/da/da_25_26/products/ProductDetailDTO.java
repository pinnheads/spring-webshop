package com.da.da_25_26.products;

public class ProductDetailDTO {
  private Product product;
  private int stockCount;
  private boolean isSoldOut;

  public ProductDetailDTO(Product product, int stockCount) {
    this.product = product;
    this.stockCount = stockCount;
    this.isSoldOut = (stockCount <= 0);
  }

  public Product getProduct() {
    return product;
  }

  public int getStockCount() {
    return stockCount;
  }

  public boolean isSoldOut() {
    return isSoldOut;
  }
}

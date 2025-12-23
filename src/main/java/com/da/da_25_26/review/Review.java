package com.da.da_25_26.review;

import java.time.LocalDateTime;

public class Review {
  private Long productId;
  private String productName;
  private String userName;
  private String reviewText;
  private LocalDateTime date;

  public Review() {
    this.date = LocalDateTime.now();
  }

  public Review(Long productId, String productName, String userName, String reviewText) {
    this.productId = productId;
    this.productName = productName;
    this.userName = userName;
    this.reviewText = reviewText;
    this.date = LocalDateTime.now();
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getReviewText() {
    return reviewText;
  }

  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "Review{" +
        "productId=" + productId +
        ", productName='" + productName + '\'' +
        ", userName='" + userName + '\'' +
        ", reviewText='" + reviewText + '\'' +
        ", date=" + date +
        '}';
  }
}

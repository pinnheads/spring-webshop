package com.da.da_25_26.review;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.da.da_25_26.products.ProductDetailDTO;
import com.da.da_25_26.products.facade.ProductDetailFacade;

@Controller
public class ReviewController {

  private ProductDetailFacade productDetailFacade;

  public ReviewController(ProductDetailFacade productDetailFacade) {
    this.productDetailFacade = productDetailFacade;
  }

  @PostMapping("/review/submit")
  public String submitReview(
      @RequestParam Long productId,
      @RequestParam String productName,
      @RequestParam String userName,
      @RequestParam String reviewText,
      Model model) {

    Review review = new Review(productId, productName, userName, reviewText);

    LocalDateTime now = LocalDateTime.now();
    review.setDate(now);
    System.out.println(review.toString());

    model.addAttribute("newReview", review);
    model.addAttribute("productDetailDTO", productDetailFacade.getProductDetailsById(productId));

    return "detail";
  }
}

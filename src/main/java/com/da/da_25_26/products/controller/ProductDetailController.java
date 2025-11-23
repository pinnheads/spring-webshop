package com.da.da_25_26.products.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.da.da_25_26.products.facade.ProductDetailFacade;

@Controller
@RequestMapping("/api/products")
public class ProductDetailController {

  private ProductDetailFacade productDetailFacade;

  public ProductDetailController(ProductDetailFacade productDetailFacade) {
    this.productDetailFacade = productDetailFacade;
  }

  @GetMapping("/details/{id}")
  public String getProductById(@PathVariable long id, Model model) {
    try {
      model.addAttribute("productDetailDTO", productDetailFacade.getProductDetailsById(id));
      return "detail";
    } catch (RuntimeException e) {
      return "redirect:/api/products";
    }
  }
}

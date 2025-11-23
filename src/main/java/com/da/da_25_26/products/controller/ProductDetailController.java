package com.da.da_25_26.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.da.da_25_26.products.IProductService;

@Controller
@RequestMapping("/api/products")
public class ProductDetailController {

  private final IProductService productService;

  @Autowired
  public ProductDetailController(IProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/details/{id}")
  public String getProductById(@PathVariable long id, Model model) {
    model.addAttribute("item", productService.getSingleProduct(id).get());
    return "detail";
  }
}

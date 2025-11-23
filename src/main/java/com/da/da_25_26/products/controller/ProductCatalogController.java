package com.da.da_25_26.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.da.da_25_26.products.Product;
import com.da.da_25_26.products.IProductService;

@Controller
@RequestMapping("/api/products")
public class ProductCatalogController {

  private final IProductService productService;

  @Autowired
  public ProductCatalogController(IProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  public String allProducts(Model model) {
    model.addAttribute("allProducts", productService.getAllProducts());
    return "catalog";
  }
}

package com.da.da_25_26.products.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
  public String allProducts(@RequestParam(name = "edit", required = false) Boolean edit,
      @RequestParam(name = "color", required = false, defaultValue = "All") String color,
      Model model) {
    model.addAttribute("edit", edit);
    model.addAttribute("allProducts", productService.fetchProductsByColor(color));
    return "catalog";
  }

  @GetMapping("/delete/{id}")
  public String deleteProduct(@PathVariable long id, Model model) {
    productService.deleteProductById(id);
    return "redirect:/api/products?edit=true";
  }
}

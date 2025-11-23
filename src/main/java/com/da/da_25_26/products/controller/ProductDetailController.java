package com.da.da_25_26.products.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.da.da_25_26.products.IProductService;
import com.da.da_25_26.products.Product;
import com.da.da_25_26.products.ProductDetailDTO;
import com.da.da_25_26.products.service.InventoryService;

@Controller
@RequestMapping("/api/products")
public class ProductDetailController {

  private final IProductService productService;
  private final InventoryService inventoryService;

  @Autowired
  public ProductDetailController(IProductService productService, InventoryService inventoryService) {
    this.productService = productService;
    this.inventoryService = inventoryService;
  }

  @GetMapping("/details/{id}")
  public String getProductById(@PathVariable long id, Model model) {
    Optional<Product> productOpt = productService.getSingleProduct(id);

    if (productOpt.isPresent()) {
      Product product = productOpt.get();

      int stock = inventoryService.getStockForProductId(product.getId());
      ProductDetailDTO dto = new ProductDetailDTO(product, stock);

      model.addAttribute("productDetailDTO", dto);

      return "detail";
    } else {
      return "redirect:/api/products";
    }
  }
}

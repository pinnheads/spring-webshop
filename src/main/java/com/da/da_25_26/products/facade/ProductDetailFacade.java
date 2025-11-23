package com.da.da_25_26.products.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.da_25_26.products.IProductService;
import com.da.da_25_26.products.Product;
import com.da.da_25_26.products.ProductDetailDTO;
import com.da.da_25_26.products.service.InventoryService;

@Service
public class ProductDetailFacade {
  private IProductService productService;
  private InventoryService inventoryService;

  @Autowired
  public ProductDetailFacade(IProductService productService, InventoryService inventoryService) {
    this.productService = productService;
    this.inventoryService = inventoryService;
  }

  public ProductDetailDTO getProductDetailsById(Long id) {
    Optional<Product> productOpt = productService.getSingleProduct(id);

    if (productOpt.isPresent()) {
      Product product = productOpt.get();

      int stock = inventoryService.getStockForProductId(product.getId());
      ProductDetailDTO dto = new ProductDetailDTO(product, stock);
      return dto;
    }

    throw new RuntimeException("Product not found with ID: " + id);
  }
}

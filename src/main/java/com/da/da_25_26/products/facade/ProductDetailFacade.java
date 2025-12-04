package com.da.da_25_26.products.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.da_25_26.products.IProductService;
import com.da.da_25_26.products.Product;
import com.da.da_25_26.products.ProductDetailDTO;
import com.da.da_25_26.products.service.InventoryService;

/**
 * **Purpose**
 * Facade service to retrieve detailed product information with inventory data
 *
 * **Requirements**
 * {@link IProductService}: Source for static product details
 * {@link InventoryService}: Source for real time stock availability
 *
 * **Capabilities**
 * Fetches a product by ID and populates the current stock levels
 * Handles product not found scenarios by validating ID existence before
 * fetching stock.
 */
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

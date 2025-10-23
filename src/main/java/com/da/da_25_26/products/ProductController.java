package com.da.da_25_26.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

  private IProductService productService;

  // Controller Injection
  @Autowired
  public ProductController(IProductService productService) {
    this.productService = productService;
  }

  // Setter Injection
  @Autowired
  public void setProductService(IProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/")
  public List<Product> getAllProducts() {
    return Product.getProducts();
  }

  @GetMapping("/{reqId}")
  public Optional<Product> getProductWithId(@PathVariable long reqId) {
    Optional<Product> product = Product.getProducts().stream()
        .filter(item -> item.getId() == reqId)
        .findFirst();
    return product;
  }

  @GetMapping("/color/{color}")
  public List<Product> getProductsWithColor(@PathVariable String color) {
    List<Product> colorProducts = productService.filterProductByColor(color);
    return colorProducts;
  }

  @GetMapping("/size/{size}")
  public List<Product> getProductsWithSize(@PathVariable String size) {
    List<Product> sizeProducts = productService.filterProductBySize(size);
    return sizeProducts;
  }
}

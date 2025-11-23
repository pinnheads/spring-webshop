package com.da.da_25_26.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("")
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  @GetMapping("/{reqId}")
  public Optional<Product> getProductWithId(@PathVariable long reqId) {
    return productService.getSingleProduct(reqId);
  }

  @PostMapping("/create")
  public Product createNewProduct(@RequestParam String name, @RequestParam String size, @RequestParam String color,
      @RequestParam double price) {
    return productService.createProduct(name, size, color, price);
  }

  @PostMapping("/add")
  public Product addNewProduct(@RequestBody Product product) {
    return productService.addProduct(product);
  }

  @GetMapping("/update")
  public ResponseEntity<Resource> getProductForUpdate() {
    Resource resource = new ClassPathResource("./static/update/product.html");
    return ResponseEntity.ok()
        .contentType(MediaType.TEXT_HTML)
        .body(resource);
  }

  @PutMapping("/update/{id}")
  public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
    return productService.updateProduct(id, updatedProduct);
  }

  @DeleteMapping("/delete/{id}")
  public List<Product> deleteProduct(@PathVariable Long id) {
    return productService.deleteProductById(id);
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

package com.da.da_25_26;

import com.da.da_25_26.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
 
import java.util.List;

@RestController
public class ProductController {
  
  @GetMapping("/products")
  public List<Product> getAllProducts() {
    return Product.getProducts();
  }
}

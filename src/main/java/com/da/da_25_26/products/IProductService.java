package com.da.da_25_26.products;

import java.util.List;
import java.util.Optional;

public interface IProductService {
  // List<Product> filterProductByColor(String color);

  Product addProduct(Product newProduct);

  List<Product> deleteProductById(Long id);

  // Product updateProduct(Long id, Product updatedProduct);

  Optional<Product> getSingleProduct(Long id);

  List<Product> getAllProducts();
}

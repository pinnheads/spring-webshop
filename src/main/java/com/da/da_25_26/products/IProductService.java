package com.da.da_25_26.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
  Page<Product> fetchProductsByColor(String color, Pageable pageable);

  Product addProduct(Product newProduct);

  List<Product> deleteProductById(Long id);

  // Product updateProduct(Long id, Product updatedProduct);

  Optional<Product> getSingleProduct(Long id);

  Page<Product> getAllProducts(Pageable pageable);
}

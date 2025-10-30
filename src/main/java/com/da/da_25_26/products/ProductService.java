package com.da.da_25_26.products;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

  @Override
  public List<Product> filterProductByColor(String color) {
    return Product.getProducts().stream()
        .filter(item -> item.getColor().equalsIgnoreCase(color))
        .collect(Collectors.toList());
  }

  @Override
  public List<Product> filterProductBySize(String size) {
    return Product.getProducts().stream()
        .filter(item -> item.getSize().equalsIgnoreCase(size))
        .collect(Collectors.toList());
  }

  @Override
  public Product createProduct(String name, String size, String color, Double price) {
    return Product.createProduct(name, size, color, price);
  }
}

package com.da.da_25_26.products;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

  private final ProductRepository repository;

  ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Product addProduct(Product newProduct) {
    return repository.save(newProduct);
  }

  @Override
  public List<Product> deleteProductById(Long id) {
    try {
      repository.deleteById(id);
      return getAllProducts();
    } catch (Exception e) {
      throw new RuntimeException("Could not find the product with ID: " + id);
    }
  }

  @Override
  public Optional<Product> getSingleProduct(Long id) {
    return repository.findById(id);
  }

  @Override
  public List<Product> getAllProducts() {
    return repository.findAll();
  }
}

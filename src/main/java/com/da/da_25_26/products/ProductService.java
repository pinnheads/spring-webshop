package com.da.da_25_26.products;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
      return repository.findAll();
    } catch (Exception e) {
      throw new RuntimeException("Could not find the product with ID: " + id);
    }
  }

  @Override
  public Page<Product> fetchProductsByColor(String color, Pageable pageable) {
    switch (color) {
      case "Black":
        return repository.fetchAllBlack(pageable);
      case "Blue":
        return repository.fetchAllBlue(pageable);
      case "Brown":
        return repository.fetchAllBrown(pageable);
      case "Gray":
        return repository.fetchAllGray(pageable);
      default:
        return repository.findAll(pageable);
    }
  }

  @Override
  public Optional<Product> getSingleProduct(Long id) {
    return repository.findById(id);
  }

  @Override
  public Page<Product> getAllProducts(Pageable pageable) {
    return repository.findAll(pageable);
  }
}

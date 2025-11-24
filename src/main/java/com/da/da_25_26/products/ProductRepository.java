package com.da.da_25_26.products;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> fetchAllBlack();

  List<Product> fetchAllBrown();

  List<Product> fetchAllBlue();

  List<Product> fetchAllGray();
}

package com.da.da_25_26.products;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Page<Product> fetchAllBlack(Pageable pageable);

  Page<Product> fetchAllBrown(Pageable pageable);

  Page<Product> fetchAllBlue(Pageable pageable);

  Page<Product> fetchAllGray(Pageable pageable);
}

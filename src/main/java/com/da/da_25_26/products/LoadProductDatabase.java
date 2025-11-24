package com.da.da_25_26.products;

import org.springframework.context.annotation.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class LoadProductDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadProductDatabase.class);

  @Bean
  CommandLineRunner initDatabase(ProductRepository repository) {
    return args -> {
      while (repository.findAll().size() < 10) {
        log.info("Preloading " + repository.save(new Product("Classic T-Shirt", 13.99, "M", "White")));
        log.info("Preloading " + repository.save(new Product("Running Shoes", 10.99, "42", "Blue")));
        log.info("Preloading " + repository.save(new Product("Denim Jeans", 18.99, "42", "Blue")));
        log.info("Preloading " + repository.save(new Product("Wool Scarf", 179.99, "M", "Sky Blue")));
        log.info("Preloading " + repository.save(new Product("Leather Belt", 109.99, "L", "Brown")));
        log.info("Preloading " + repository.save(new Product("Leather Jacket", 219.99, "L", "Brown")));
        log.info("Preloading " + repository.save(new Product("Long Coat", 189.99, "S", "Gray")));
        log.info("Preloading " + repository.save(new Product("Puffer Jacket", 129.99, "XL", "Pastel Brown")));
        log.info("Preloading " + repository.save(new Product("Smart Watch", 179.99, "-", "Midnight Black")));
        log.info("Preloading " + repository.save(new Product("Smart Phone", 1119.99, "-", "Product Red")));
      }
    };
  }
}

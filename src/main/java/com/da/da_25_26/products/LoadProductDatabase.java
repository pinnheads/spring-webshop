package com.da.da_25_26.products;

import java.math.BigDecimal;
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
      if (repository.findAll().size() < 10) {
        log.info("Preloading " + repository.save(new Product("Classic T-Shirt", new BigDecimal(13.99), "M", "Black")));
        log.info("Preloading " + repository.save(new Product("Running Shoes", new BigDecimal(10.99), "42", "Blue")));
        log.info("Preloading " + repository.save(new Product("Denim Jeans", new BigDecimal(18.99), "42", "Blue")));
        log.info("Preloading " + repository.save(new Product("Wool Scarf", new BigDecimal(179.99), "M", "Blue")));
        log.info("Preloading " + repository.save(new Product("Leather Belt", new BigDecimal(109.99), "L", "Brown")));
        log.info("Preloading " + repository.save(new Product("Leather Jacket", new BigDecimal(119.99), "L", "Brown")));
        log.info("Preloading " + repository.save(new Product("Long Coat", new BigDecimal(189.99), "S", "Gray")));
        log.info("Preloading " + repository.save(new Product("Puffer Jacket", new BigDecimal(129.99), "XL", "Brown")));
        log.info("Preloading " + repository.save(new Product("Smart Watch", new BigDecimal(179.99), "-", "Black")));
        log.info("Preloading " + repository.save(new Product("Smart Phone", new BigDecimal(1119.99), "-", "Gray")));
      }
    };
  }
}

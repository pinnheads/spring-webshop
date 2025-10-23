package com.da.da_25_26.products;

import java.util.List;

interface IProductService {
  List<Product> filterProductByColor(String color);

  List<Product> filterProductBySize(String size);
}

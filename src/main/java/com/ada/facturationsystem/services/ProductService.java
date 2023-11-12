package com.ada.facturationsystem.services;

import com.ada.facturationsystem.domain.models.entity.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProductService {
  @Transactional(readOnly = true)
  List<Product> getAll();

  @Transactional(readOnly = true)
  Product findById(Long id);

  @Transactional
  Product save(Product item);

  @Transactional
  void delete(Long id);

  public List<Product> findAllProducts();

  public Product findProductById(Long id);

  public Product saveProduct(Product product);

}

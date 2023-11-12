package com.ada.facturationsystem.services.impl;

import com.ada.facturationsystem.domain.models.entity.Product;
import com.ada.facturationsystem.domain.repositories.ProductRepository;
import com.ada.facturationsystem.services.ProductService;
import com.ada.facturationsystem.errors.Errors;
import com.ada.facturationsystem.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository repository;

  @Override
  @Transactional(readOnly = true)
  public List<Product> getAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Product findById(Long id) {
    return repository.findById(id).orElseThrow(
            () -> new ApplicationException(Errors.ITEM_NOT_FOUND, Map.of("info",   Product.class.getName() + " with " + id + " not found")));
  }

  @Override
  @Transactional
  public Product save(Product item) {
    return repository.save(item);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    Product itemDB = this.findById(id);
    repository.delete(itemDB);
  }

  public List<Product> findAllProducts() {
    return repository.findAll();
  }

  public Product findProductById(Long id) {
    return repository.findById(id).orElse(null);
  }

  public Product saveProduct(Product product) {
    return repository.save(product);
  }

}

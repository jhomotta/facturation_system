package com.ada.facturationsystem.controller;


import com.ada.facturationsystem.controller.api.dto.request.ProductRequest;
import com.ada.facturationsystem.controller.api.dto.response.ProductResponse;
import com.ada.facturationsystem.controller.api.mapper.request.ProductRequestMapper;
import com.ada.facturationsystem.controller.api.mapper.response.ProductResponseMapper;
import com.ada.facturationsystem.domain.models.entity.Product;
import com.ada.facturationsystem.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/product")
@Slf4j
public class ProductController {

  @Autowired
  private ProductService service;

  @Autowired
  private ProductRequestMapper productRequestMapper;

  @Autowired
  private ProductResponseMapper productResponseMapper;

  @PostMapping
  public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest) {
    Product product = productRequestMapper.toEntity(productRequest);
    Product savedProduct = service.save(product);
    ProductResponse productResponse = productResponseMapper.toModel(savedProduct);
    return new ResponseEntity<>(productResponse, HttpStatus.CREATED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
    Product product = service.findById(id);
    if (product == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    ProductResponse productResponse = productResponseMapper.toModel(product);
    return ResponseEntity.ok(productResponse);
  }

  @GetMapping
  public ResponseEntity<List<ProductResponse>> getAllProducts() {
    List<Product> products = service.getAll();
    List<ProductResponse> productResponses = products.stream()
            .map(productResponseMapper::toModel)
            .collect(Collectors.toList());
    return ResponseEntity.ok(productResponses);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest productRequest) {
    Product existingProduct = service.findById(id);
    if (existingProduct == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Actualiza los campos del producto existente con los valores del DTO
    // Este es un enfoque simple. Considera usar un mapper o una estrategia más sofisticada para actualizar.
    existingProduct.setName(productRequest.getName());
    existingProduct.setPrice(productRequest.getPrice());
    Product updatedProduct = service.save(existingProduct);
    ProductResponse productResponse = productResponseMapper.toModel(updatedProduct);
    return ResponseEntity.ok(productResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}

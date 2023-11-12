package com.ada.facturationsystem.controller;

import com.ada.facturationsystem.controller.api.dto.request.SellerRequest;
import com.ada.facturationsystem.controller.api.dto.response.SellerResponse;
import com.ada.facturationsystem.controller.api.mapper.request.SellerRequestMapper;
import com.ada.facturationsystem.controller.api.mapper.response.SellerResponseMapper;
import com.ada.facturationsystem.services.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.facturationsystem.domain.models.entity.Seller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/seller")
@Slf4j
public class SellerController {
  @Autowired
  private SellerService service;

  @Autowired
  private SellerRequestMapper sellerRequestMapper;

  @Autowired
  private SellerResponseMapper sellerResponseMapper;

  @GetMapping
  public ResponseEntity<List<SellerResponse>> getAllSellers() {
    List<Seller> sellers = service.getAll();
    List<SellerResponse> sellerResponses = sellers.stream()
            .map(sellerResponseMapper::toModel)
            .collect(Collectors.toList());
    return ResponseEntity.ok(sellerResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SellerResponse> getSellerById(@PathVariable Long id) {
    Seller seller = service.findById(id);
    if (seller == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    SellerResponse sellerResponse = sellerResponseMapper.toModel(seller);
    return ResponseEntity.ok(sellerResponse);
  }

  @PostMapping
  public ResponseEntity<SellerResponse> createSeller(@RequestBody SellerRequest sellerRequest) {
    Seller seller = sellerRequestMapper.toEntity(sellerRequest);
    Seller savedSeller = service.save(seller);
    SellerResponse sellerResponse = sellerResponseMapper.toModel(savedSeller);
    return new ResponseEntity<>(sellerResponse, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SellerResponse> updateSeller(@PathVariable Long id, @RequestBody SellerRequest sellerRequest) {
    Seller existingSeller = service.findById(id);
    if (existingSeller == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    Seller updatedSeller = sellerRequestMapper.toEntity(sellerRequest);
    updatedSeller.setId(id); // Asegúrate de establecer el ID correcto
    Seller savedSeller = service.save(updatedSeller);
    SellerResponse sellerResponse = sellerResponseMapper.toModel(savedSeller);
    return ResponseEntity.ok(sellerResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSeller(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}

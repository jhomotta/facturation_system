package com.ada.facturationsystem.controller;

import com.ada.facturationsystem.controller.api.dto.request.InventoryRequest;
import com.ada.facturationsystem.controller.api.dto.response.InventoryResponse;
import com.ada.facturationsystem.controller.api.mapper.request.InventoryRequestMapper;
import com.ada.facturationsystem.controller.api.mapper.response.InventoryResponseMapper;
import com.ada.facturationsystem.domain.models.entity.Inventory;
import com.ada.facturationsystem.services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/inventory")
@Slf4j
public class InventoryController {
  @Autowired
  private InventoryService service;

  @Autowired
  private InventoryRequestMapper inventoryRequestMapper;

  @Autowired
  private InventoryResponseMapper inventoryResponseMapper;

  @GetMapping
  public ResponseEntity<List<InventoryResponse>> getAllInventory() {
    List<Inventory> inventoryList = service.getAll();
    List<InventoryResponse> inventoryResponses = inventoryList.stream()
            .map(inventoryResponseMapper::toModel)
            .collect(Collectors.toList());
    return ResponseEntity.ok(inventoryResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<InventoryResponse> getInventoryById(@PathVariable Long id) {
    Inventory inventory = service.findById(id);
    InventoryResponse inventoryResponse = inventoryResponseMapper.toModel(inventory);
    return ResponseEntity.ok(inventoryResponse);
  }

  @PostMapping
  public ResponseEntity<InventoryResponse> createInventory(@RequestBody InventoryRequest inventoryRequest) {
    Inventory inventory = inventoryRequestMapper.toEntity(inventoryRequest);
    Inventory savedInventory = service.save(inventory);
    InventoryResponse inventoryResponse = inventoryResponseMapper.toModel(savedInventory);
    return new ResponseEntity<>(inventoryResponse, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<InventoryResponse> updateInventory(@PathVariable Long id, @RequestBody InventoryRequest inventoryRequest) {
    Inventory existingInventory = service.findById(id);
    Inventory inventoryToUpdate = inventoryRequestMapper.toEntity(inventoryRequest);
    Inventory updatedInventory = service.updateInventory(inventoryToUpdate);
    InventoryResponse inventoryResponse = inventoryResponseMapper.toModel(updatedInventory);
    return ResponseEntity.ok(inventoryResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteInventory(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/product/{productId}")
  public ResponseEntity<InventoryResponse> getInventoryByProductId(@PathVariable Long productId) {
    Inventory inventory = service.findById(productId);
    InventoryResponse inventoryResponse = inventoryResponseMapper.toModel(inventory);
    return ResponseEntity.ok(inventoryResponse);
  }
}

package com.ada.facturationsystem.services.impl;

import com.ada.facturationsystem.domain.models.entity.Inventory;
import com.ada.facturationsystem.domain.models.entity.Inventory;
import com.ada.facturationsystem.domain.repositories.InventoryRepository;
import com.ada.facturationsystem.errors.Errors;
import com.ada.facturationsystem.exception.ApplicationException;
import com.ada.facturationsystem.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements InventoryService {

  @Autowired
  private InventoryRepository repository;

  @Override
  @Transactional(readOnly = true)
  public List<Inventory> getAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Inventory findById(Long id) {
    return repository.findById(id).orElseThrow(
            () -> new ApplicationException(Errors.ITEM_NOT_FOUND, Map.of("info",   Inventory.class.getName() + " with " + id + " not found")));
  }

  @Override
  @Transactional
  public Inventory save(Inventory item) {
    return repository.save(item);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    Inventory itemDB = this.findById(id);
    repository.delete(itemDB);
  }

  public Inventory updateInventory(Inventory inventory) {
    return repository.save(inventory);
  }
}

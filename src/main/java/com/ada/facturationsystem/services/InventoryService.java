package com.ada.facturationsystem.services;

import com.ada.facturationsystem.domain.models.entity.Inventory;
import com.ada.facturationsystem.domain.models.entity.Inventory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InventoryService {
  @Transactional(readOnly = true)
  List<Inventory> getAll();

  @Transactional(readOnly = true)
  Inventory findById(Long id);

  @Transactional
  Inventory save(Inventory item);

  @Transactional
  void delete(Long id);

  public Inventory updateInventory(Inventory inventory);
}

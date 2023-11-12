package com.ada.facturationsystem.services.impl;

import com.ada.facturationsystem.domain.models.entity.*;
import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.repositories.SaleRepository;
import com.ada.facturationsystem.errors.Errors;
import com.ada.facturationsystem.exception.ApplicationException;
import com.ada.facturationsystem.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SaleServiceImpl implements SaleService {
  @Autowired
  private SaleRepository repository;

  @Autowired
  private SellerService sellerService;

  @Autowired
  private ProductService productService;

  @Autowired
  private SaleDetailService saleDetailService;

  @Autowired
  private InventoryService inventoryService;

  @Override
  @Transactional(readOnly = true)
  public List<Sale> getAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Sale findById(Long id) {
    return repository.findById(id).orElseThrow(
            () -> new ApplicationException(Errors.ITEM_NOT_FOUND, Map.of("info",   Sale.class.getName() + " with " + id + " not found")));
  }

  @Override
  @Transactional
  public Sale save(Sale sale) {

    this.validateInventory(sale);

    sale.setSeller(sellerService.findById(sale.getSeller().getId()));

    Sale savedSale = repository.save(sale);

    saveSaleDetails(sale);

    return savedSale;
  }

  @Override
  @Transactional
  public void delete(Long id) {
    Sale itemDB = this.findById(id);
    repository.delete(itemDB);
  }

  public List<Sale> findSalesBySeller(Seller seller) {
    return repository.findBySeller(seller);
  }


  private void validateInventory(Sale sale) {
    for (SaleDetail detail : sale.getSaleDetails()) {
      Inventory inventoryItem = inventoryService.findById(detail.getProduct().getId());
      if (inventoryItem.getQuantity() < detail.getQuantity()) {
        throw new ApplicationException(Errors.ITEM_CONFICT, Map.of("info", "STOCK_INSUFFICIENT product: " + inventoryItem.getId() + " the quantity in inventory is: " + inventoryItem.getQuantity()));
      }
    }
  }

  private void saveSaleDetails(Sale sale) {
    for (SaleDetail detail : sale.getSaleDetails()) {
      updateInventory(detail);
      detail.setSale(sale);
      saleDetailService.save(detail);
    }
  }

  private void updateInventory(SaleDetail detail) {
    Inventory inventoryItem = inventoryService.findById(detail.getProduct().getId());
    inventoryItem.setQuantity(inventoryItem.getQuantity() - detail.getQuantity());
    inventoryService.save(inventoryItem);
  }

}

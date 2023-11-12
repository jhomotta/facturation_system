package com.ada.facturationsystem.services;

import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.models.entity.Seller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SaleService {
  @Transactional(readOnly = true)
  List<Sale> getAll();

  @Transactional(readOnly = true)
  Sale findById(Long id);

  @Transactional
  Sale save(Sale item);

  @Transactional
  void delete(Long id);

  public List<Sale> findSalesBySeller(Seller seller);
}

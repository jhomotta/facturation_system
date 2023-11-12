package com.ada.facturationsystem.services;

import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.models.entity.SaleDetail;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SaleDetailService {
  @Transactional(readOnly = true)
  List<SaleDetail> getAll();

  @Transactional(readOnly = true)
  SaleDetail findById(Long id);

  @Transactional
  SaleDetail save(SaleDetail item);

  @Transactional
  void delete(Long id);

  public List<SaleDetail> findSaleDetailsBySale(Sale sale);
}

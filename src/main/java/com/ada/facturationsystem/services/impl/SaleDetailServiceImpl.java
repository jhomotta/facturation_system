package com.ada.facturationsystem.services.impl;

import com.ada.facturationsystem.domain.models.entity.SaleDetail;
import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.repositories.SaleDetailRepository;
import com.ada.facturationsystem.errors.Errors;
import com.ada.facturationsystem.exception.ApplicationException;
import com.ada.facturationsystem.services.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SaleDetailServiceImpl implements SaleDetailService {
  @Autowired
  private SaleDetailRepository repository;

  @Override
  @Transactional(readOnly = true)
  public List<SaleDetail> getAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public SaleDetail findById(Long id) {
    return repository.findById(id).orElseThrow(
            () -> new ApplicationException(Errors.ITEM_NOT_FOUND, Map.of("info",   SaleDetail.class.getName() + " with " + id + " not found")));
  }

  @Override
  @Transactional
  public SaleDetail save(SaleDetail item) {
    return repository.save(item);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    SaleDetail itemDB = this.findById(id);
    repository.delete(itemDB);
  }

  public List<SaleDetail> findSaleDetailsBySale(Sale sale) {
    return repository.findBySale(sale);
  }

}

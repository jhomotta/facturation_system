package com.ada.facturationsystem.services;

import com.ada.facturationsystem.domain.models.entity.Seller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SellerService {
  @Transactional(readOnly = true)
  List<Seller> getAll();

  @Transactional(readOnly = true)
  Seller findById(Long id);

  @Transactional
  Seller save(Seller item);

  @Transactional
  void delete(Long id);

  public Seller findSellerById(Long id);
}

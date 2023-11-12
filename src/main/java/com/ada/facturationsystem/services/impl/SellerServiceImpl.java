package com.ada.facturationsystem.services.impl;

import com.ada.facturationsystem.domain.models.entity.Seller;
import com.ada.facturationsystem.domain.models.entity.Seller;
import com.ada.facturationsystem.domain.repositories.SellerRepository;
import com.ada.facturationsystem.errors.Errors;
import com.ada.facturationsystem.exception.ApplicationException;
import com.ada.facturationsystem.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SellerServiceImpl implements SellerService {

  @Autowired
  private SellerRepository repository;

  @Override
  @Transactional(readOnly = true)
  public List<Seller> getAll() {
    return repository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Seller findById(Long id) {
    return repository.findById(id).orElseThrow(
            () -> new ApplicationException(Errors.ITEM_NOT_FOUND, Map.of("info",   Seller.class.getName() + " with " + id + " not found")));
  }

  @Override
  @Transactional
  public Seller save(Seller item) {
    return repository.save(item);
  }

  @Override
  @Transactional
  public void delete(Long id) {
    Seller itemDB = this.findById(id);
    repository.delete(itemDB);
  }

  public Seller findSellerById(Long id) {
    return repository.findById(id).orElse(null);
  }

}

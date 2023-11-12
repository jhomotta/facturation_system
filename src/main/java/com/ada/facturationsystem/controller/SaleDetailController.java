package com.ada.facturationsystem.controller;

import com.ada.facturationsystem.controller.api.dto.request.SaleDetailRequest;
import com.ada.facturationsystem.controller.api.dto.response.SaleDetailResponse;
import com.ada.facturationsystem.controller.api.mapper.request.SaleDetailRequestMapper;
import com.ada.facturationsystem.controller.api.mapper.response.SaleDetailResponseMapper;
import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.models.entity.SaleDetail;
import com.ada.facturationsystem.services.SaleDetailService;
import com.ada.facturationsystem.services.SaleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/sale-details")
@Slf4j
public class SaleDetailController {

  @Autowired
  private SaleDetailService service;

  @Autowired
  private SaleService saleService;

  @Autowired
  private SaleDetailRequestMapper saleDetailRequestMapper;

  @Autowired
  private SaleDetailResponseMapper saleDetailResponseMapper;

  @GetMapping
  public ResponseEntity<List<SaleDetailResponse>> getAllSaleDetails() {
    List<SaleDetail> saleDetails = service.getAll();
    List<SaleDetailResponse> saleDetailResponses = saleDetails.stream()
            .map(saleDetailResponseMapper::toModel)
            .collect(Collectors.toList());
    return ResponseEntity.ok(saleDetailResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SaleDetailResponse> getSaleDetailById(@PathVariable Long id) {
    SaleDetail saleDetail = service.findById(id);
    if (saleDetail == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    SaleDetailResponse saleDetailResponse = saleDetailResponseMapper.toModel(saleDetail);
    return ResponseEntity.ok(saleDetailResponse);
  }

  @PostMapping
  public ResponseEntity<SaleDetailResponse> createSaleDetail(@RequestBody SaleDetailRequest saleDetailRequest) {
    SaleDetail saleDetail = saleDetailRequestMapper.toEntity(saleDetailRequest);
    SaleDetail savedSaleDetail = service.save(saleDetail);
    SaleDetailResponse saleDetailResponse = saleDetailResponseMapper.toModel(savedSaleDetail);
    return new ResponseEntity<>(saleDetailResponse, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SaleDetailResponse> updateSaleDetail(@PathVariable Long id, @RequestBody SaleDetailRequest saleDetailRequest) {
    SaleDetail existingSaleDetail = service.findById(id);
    if (existingSaleDetail == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    // Implementa la lógica de actualización aquí
    SaleDetail updatedSaleDetail = service.save(existingSaleDetail);
    SaleDetailResponse saleDetailResponse = saleDetailResponseMapper.toModel(updatedSaleDetail);
    return ResponseEntity.ok(saleDetailResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSaleDetail(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/sale/{saleId}")
  public ResponseEntity<List<SaleDetailResponse>> getSaleDetailsBySale(@PathVariable Long saleId) {
    Sale sale = saleService.findById(saleId);
    if (sale == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    List<SaleDetail> saleDetails = service.findSaleDetailsBySale(sale);
    List<SaleDetailResponse> saleDetailResponses = saleDetails.stream()
            .map(saleDetailResponseMapper::toModel)
            .collect(Collectors.toList());
    return ResponseEntity.ok(saleDetailResponses);
  }
}
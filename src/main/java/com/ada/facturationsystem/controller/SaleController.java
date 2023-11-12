package com.ada.facturationsystem.controller;

import com.ada.facturationsystem.controller.api.dto.request.SaleDetailRequest;
import com.ada.facturationsystem.controller.api.dto.request.SaleRequest;
import com.ada.facturationsystem.controller.api.dto.response.SaleResponse;
import com.ada.facturationsystem.controller.api.mapper.request.SaleDetailRequestMapper;
import com.ada.facturationsystem.controller.api.mapper.request.SaleRequestMapper;
import com.ada.facturationsystem.controller.api.mapper.response.SaleResponseMapper;
import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.models.entity.SaleDetail;
import com.ada.facturationsystem.domain.models.entity.Seller;
import com.ada.facturationsystem.services.SaleService;
import com.ada.facturationsystem.services.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping(value = "/sale")
@Slf4j
public class SaleController {

  @Autowired
  private SaleService saleService;

  @Autowired
  private SellerService sellerService;

  @Autowired
  private SaleRequestMapper saleRequestMapper;

  @Autowired
  private SaleResponseMapper saleResponseMapper;

  @Autowired
  private SaleDetailRequestMapper saleDetailRequestMapper;



  @GetMapping
  public ResponseEntity<List<SaleResponse>> getAllSales() {
    List<Sale> sales = saleService.getAll();
    List<SaleResponse> saleResponses = sales.stream()
            .map(saleResponseMapper::toModel)
            .collect(Collectors.toList());
    return ResponseEntity.ok(saleResponses);
  }

  @GetMapping("/{id}")
  public ResponseEntity<SaleResponse> getSaleById(@PathVariable Long id) {
    Sale sale = saleService.findById(id);
    if (sale == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    SaleResponse saleResponse = saleResponseMapper.toModel(sale);
    return ResponseEntity.ok(saleResponse);
  }

  @PostMapping
  public ResponseEntity<SaleResponse> createSale(@RequestBody SaleRequest saleRequest) {
    Sale sale = saleRequestMapper.toEntity(saleRequest);

    List<SaleDetail> saleDetails = new ArrayList<SaleDetail>();
    for (SaleDetailRequest item :  saleRequest.getSaleDetails()) {
      saleDetails.add(saleDetailRequestMapper.toEntity(item));
    }

    sale.setSaleDetails(saleDetails);

    Sale savedSale = saleService.save(sale);
    SaleResponse saleResponse = saleResponseMapper.toModel(savedSale);
    return new ResponseEntity<>(saleResponse, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<SaleResponse> updateSale(@PathVariable Long id, @RequestBody SaleRequest saleRequest) {
    Sale existingSale = saleService.findById(id);

    Sale updatedSale = saleService.save(existingSale);
    SaleResponse saleResponse = saleResponseMapper.toModel(updatedSale);
    return ResponseEntity.ok(saleResponse);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
    saleService.delete(id);
    return ResponseEntity.noContent().build();
  }

  @GetMapping("/seller/{sellerId}")
  public ResponseEntity<List<SaleResponse>> getSalesBySeller(@PathVariable Long sellerId) {
    Seller seller = sellerService.findById(sellerId);
    if (seller == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    List<Sale> sales = saleService.findSalesBySeller(seller);
    List<SaleResponse> saleResponses = sales.stream()
            .map(saleResponseMapper::toModel)
            .collect(Collectors.toList());
    return ResponseEntity.ok(saleResponses);
  }

}

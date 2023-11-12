package com.ada.facturationsystem.domain.repositories;

import com.ada.facturationsystem.domain.models.entity.Product;
import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.models.entity.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {
  // detalles de ventas por venta
  List<SaleDetail> findBySale(Sale sale);

  // detalle de venta por producto
  List<SaleDetail> findByProduct(Product product);
}

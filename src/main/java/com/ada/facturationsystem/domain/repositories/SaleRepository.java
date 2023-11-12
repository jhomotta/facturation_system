package com.ada.facturationsystem.domain.repositories;

import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.models.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

  // buscar ventas por vendedor
  List<Sale> findBySeller(Seller seller);

  // buscar ventas por rango de fecha
  List<Sale> findByCreationDateBetween(Instant startDate, Instant endDate);
}

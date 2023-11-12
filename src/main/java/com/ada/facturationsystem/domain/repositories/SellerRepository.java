package com.ada.facturationsystem.domain.repositories;

import com.ada.facturationsystem.domain.models.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
  // buscar vendedor por nombre
  List<Seller> findByNameContaining(String name);
}

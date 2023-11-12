package com.ada.facturationsystem.domain.repositories;

import com.ada.facturationsystem.domain.models.entity.Inventory;
import com.ada.facturationsystem.domain.models.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
  // verificar el stock de un producto específico
  Optional<Inventory> findByProduct_Id(Long porductId);
}

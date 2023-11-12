package com.ada.facturationsystem.controller.api.dto.request;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import com.ada.facturationsystem.domain.models.BaseAuditory;
import com.ada.facturationsystem.domain.models.entity.Inventory;
import com.ada.facturationsystem.domain.models.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * registrar el stock disponible de cada producto.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequest extends BaseClassDtos<InventoryRequest> {

  @Schema(description = "Product ID", example = "1", nullable = false)
  private Long productId;

  @Schema(description = "Quantity in stock", example = "100", nullable = false)
  private int quantity;

}

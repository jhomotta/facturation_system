package com.ada.facturationsystem.controller.api.dto.request;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import com.ada.facturationsystem.domain.models.BaseAuditory;
import com.ada.facturationsystem.domain.models.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Detalle específico dentro de una venta
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailRequest extends BaseClassDtos<SaleDetailRequest> {

  @Schema(description = "Product ID", example = "3", nullable = false)
  private Long productId;

  @Schema(description = "Quantity sold", example = "5", nullable = false)
  private int quantity;

  @Schema(description = "Price at the time of sale", example = "12.99", nullable = false)
  private double price;

}

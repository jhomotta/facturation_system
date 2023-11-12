package com.ada.facturationsystem.controller.api.dto.response;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import com.ada.facturationsystem.domain.models.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Detalle específico dentro de una venta
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleDetailResponse extends BaseClassDtos<SaleDetailResponse> {

  @Schema(description = "Product", example = "3", nullable = false)
  private Product product;

  @Schema(description = "Quantity sold", example = "5", nullable = false)
  private int quantity;

  @Schema(description = "Price at the time of sale", example = "12.99", nullable = false)
  private double price;

}

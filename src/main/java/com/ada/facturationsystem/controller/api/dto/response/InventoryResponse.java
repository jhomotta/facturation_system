package com.ada.facturationsystem.controller.api.dto.response;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import com.ada.facturationsystem.controller.api.dto.request.ProductRequest;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * registrar el stock disponible de cada producto.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse extends BaseClassDtos<InventoryResponse> {

  @Schema(description = "Product", example = "1", nullable = false)
  private ProductResponse product;

  @Schema(description = "Quantity in stock", example = "100", nullable = false)
  private int quantity;

}

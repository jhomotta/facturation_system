package com.ada.facturationsystem.controller.api.dto.request;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

/**
 * guardar detalles de cada venta, incluyendo el producto, cantidad, y precio.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleRequest extends BaseClassDtos<SaleRequest> {

  @Schema(description = "Seller ID", example = "2", nullable = false)
  private Long sellerId;

  @Schema(description = "List of sale details")
  private List<SaleDetailRequest> saleDetails;
}

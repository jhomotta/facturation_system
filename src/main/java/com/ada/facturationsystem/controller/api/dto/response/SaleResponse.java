package com.ada.facturationsystem.controller.api.dto.response;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * guardar detalles de cada venta, incluyendo el producto, cantidad, y precio.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SaleResponse extends BaseClassDtos<SaleResponse> {

  @Schema(description = "Seller")
  private SellerResponse seller;

  @Schema(description = "List of sale details")
  private List<SaleDetailResponse> saleDetails;

  @Schema(description = "total of the sale")
  private Double totalSale;
}

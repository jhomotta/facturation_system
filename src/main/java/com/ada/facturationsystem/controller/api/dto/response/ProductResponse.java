package com.ada.facturationsystem.controller.api.dto.response;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse extends BaseClassDtos<ProductResponse> {

  @Schema(description = "Product name", example = "Hammer", nullable = false)
  private String name;

  @Schema(description = "Price of the product in USD", example = "15.99", nullable = false)
  private double price;

}

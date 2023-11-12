package com.ada.facturationsystem.controller.api.dto.response;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * almacenar información de los vendedores.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SellerResponse extends BaseClassDtos<SellerResponse> {

  @Schema(description = "Seller name", example = "John Doe", nullable = false)
  private String name;
}

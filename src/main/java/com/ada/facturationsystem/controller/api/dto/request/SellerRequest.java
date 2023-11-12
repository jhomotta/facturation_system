package com.ada.facturationsystem.controller.api.dto.request;

import com.ada.facturationsystem.controller.api.dto.BaseClassDtos;
import com.ada.facturationsystem.domain.models.BaseAuditory;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * almacenar información de los vendedores.
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SellerRequest extends BaseClassDtos<SellerRequest> {

  @Schema(description = "Seller name", example = "John Doe", nullable = false)
  private String name;
}

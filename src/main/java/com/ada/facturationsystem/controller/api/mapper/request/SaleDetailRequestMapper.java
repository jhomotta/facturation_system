package com.ada.facturationsystem.controller.api.mapper.request;

import com.ada.facturationsystem.controller.api.dto.request.SaleDetailRequest;
import com.ada.facturationsystem.domain.models.entity.Product;
import com.ada.facturationsystem.domain.models.entity.SaleDetail;
import org.mapstruct.*;

/**
 * Mapper to convert SaleDetailRequest DTO to SaleDetail entity.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public abstract class SaleDetailRequestMapper {

  /**
   * Converts a SaleDetailRequest DTO to a SaleDetail entity.
   *
   * @param dto the DTO to create a SaleDetail record
   * @return the SaleDetail entity
   */
  public abstract SaleDetail toEntity(SaleDetailRequest dto);

  // Cualquier lógica adicional después de mapear los campos básicos
  @AfterMapping
  protected void afterMapping(SaleDetailRequest dto, @MappingTarget SaleDetail entity) {
    Product product = new Product();
    product.setId(dto.getProductId());
    entity.setProduct(product);
  }
}
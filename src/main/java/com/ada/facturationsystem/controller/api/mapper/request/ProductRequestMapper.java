package com.ada.facturationsystem.controller.api.mapper.request;

import com.ada.facturationsystem.controller.api.dto.request.ProductRequest;
import com.ada.facturationsystem.domain.models.entity.Product;
import org.mapstruct.*;
/**
 * Mapper to convert ProductRequest DTO to Product entity.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public abstract class ProductRequestMapper {

  /**
   * Converts a ProductRequest DTO to a Product entity.
   *
   * @param dto the DTO to create a Product record
   * @return the Product entity
   */
  public abstract Product toEntity(ProductRequest dto);

  // Aquí puedes agregar lógica adicional después del mapeo si es necesario
  @AfterMapping
  protected void afterMapping(ProductRequest dto, @MappingTarget Product entity) {
    // Cualquier lógica adicional después de mapear los campos básicos
  }
}
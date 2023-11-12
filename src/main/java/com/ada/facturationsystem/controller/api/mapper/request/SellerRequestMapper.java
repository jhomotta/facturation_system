package com.ada.facturationsystem.controller.api.mapper.request;

import com.ada.facturationsystem.controller.api.dto.request.SellerRequest;
import com.ada.facturationsystem.domain.models.entity.Seller;
import org.mapstruct.*;

/**
 * Mapper to convert SellerRequest DTO to Seller entity.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public abstract class SellerRequestMapper {

  /**
   * Converts a SellerRequest DTO to a Seller entity.
   *
   * @param dto the DTO to create a Seller record
   * @return the Seller entity
   */
  public abstract Seller toEntity(SellerRequest dto);

  // Aquí puedes agregar lógica adicional después del mapeo si es necesario
  @AfterMapping
  protected void afterMapping(SellerRequest dto, @MappingTarget Seller entity) {
    // Cualquier lógica adicional después de mapear los campos básicos
  }
}
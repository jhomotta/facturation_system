package com.ada.facturationsystem.controller.api.mapper.request;

import com.ada.facturationsystem.controller.api.dto.request.InventoryRequest;
import com.ada.facturationsystem.domain.models.entity.Inventory;
import org.mapstruct.*;

/**
 * Mapper to convert InventoryRequest DTO to Inventory entity.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public abstract class InventoryRequestMapper {

  /**
   * Converts a InventoryRequest DTO to a Inventory entity.
   *
   * @param dto the DTO to create a Inventory record
   * @return the Inventory entity
   */
  public abstract Inventory toEntity(InventoryRequest dto);

  // Aquí puedes agregar lógica adicional después del mapeo si es necesario
  @AfterMapping
  protected void afterMapping(InventoryRequest dto, @MappingTarget Inventory entity) {
    // Cualquier lógica adicional después de mapear los campos básicos
  }
}
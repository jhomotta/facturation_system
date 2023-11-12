package com.ada.facturationsystem.controller.api.mapper.response;

import com.ada.facturationsystem.controller.InventoryController;
import com.ada.facturationsystem.controller.api.dto.response.InventoryResponse;
import com.ada.facturationsystem.domain.models.entity.Inventory;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Mapper(componentModel = "spring")
public abstract class InventoryResponseMapper implements RepresentationModelAssembler<Inventory, InventoryResponse> {

  @Override
  @Mappings({@Mapping(source = "id", target = "id")})
  public abstract InventoryResponse toModel(Inventory entity);

  public abstract List<InventoryResponse> entitiesToEntityDTOs(List<Inventory> entities);

  @AfterMapping
  protected void addLinks(@MappingTarget InventoryResponse resource, Inventory entity) {
    Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(InventoryController.class).getInventoryById(entity.getId())).withSelfRel();
    resource.add(selfLink);

    // Aquí puedes añadir más enlaces HATEOAS según sea necesario
  }
}


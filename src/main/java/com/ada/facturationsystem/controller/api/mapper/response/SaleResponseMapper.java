package com.ada.facturationsystem.controller.api.mapper.response;

import com.ada.facturationsystem.controller.SaleController;
import com.ada.facturationsystem.controller.api.dto.response.SaleResponse;
import com.ada.facturationsystem.domain.models.entity.Sale;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Mapper(componentModel = "spring")
public abstract class SaleResponseMapper implements RepresentationModelAssembler<Sale, SaleResponse> {

  @Override
  @Mappings({@Mapping(source = "id", target = "id")})
  public abstract SaleResponse toModel(Sale entity);

  public abstract List<SaleResponse> entitiesToEntityDTOs(List<Sale> entities);

  @AfterMapping
  protected void addLinks(@MappingTarget SaleResponse resource, Sale entity) {
    Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(SaleController.class).getSaleById(entity.getId())).withSelfRel();
    resource.add(selfLink);

    // Aquí puedes añadir más enlaces HATEOAS según sea necesario
  }
}


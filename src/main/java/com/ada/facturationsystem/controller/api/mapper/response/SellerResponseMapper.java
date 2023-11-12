package com.ada.facturationsystem.controller.api.mapper.response;

import com.ada.facturationsystem.controller.SellerController;
import com.ada.facturationsystem.controller.api.dto.response.SellerResponse;
import com.ada.facturationsystem.domain.models.entity.Seller;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Mapper(componentModel = "spring")
public abstract class SellerResponseMapper implements RepresentationModelAssembler<Seller, SellerResponse> {

  @Override
  @Mappings({@Mapping(source = "id", target = "id")})
  public abstract SellerResponse toModel(Seller entity);

  public abstract List<SellerResponse> entitiesToEntityDTOs(List<Seller> entities);

  @AfterMapping
  protected void addLinks(@MappingTarget SellerResponse resource, Seller entity) {
    Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(SellerController.class).getSellerById(entity.getId())).withSelfRel();
    resource.add(selfLink);

    // Aquí puedes añadir más enlaces HATEOAS según sea necesario
  }
}


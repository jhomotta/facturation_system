package com.ada.facturationsystem.controller.api.mapper.response;

import com.ada.facturationsystem.controller.SaleDetailController;
import com.ada.facturationsystem.controller.api.dto.response.SaleDetailResponse;
import com.ada.facturationsystem.domain.models.entity.SaleDetail;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Mapper(componentModel = "spring")
public abstract class SaleDetailResponseMapper implements RepresentationModelAssembler<SaleDetail, SaleDetailResponse> {

  @Override
  @Mappings({@Mapping(source = "id", target = "id")})
  public abstract SaleDetailResponse toModel(SaleDetail entity);

  public abstract List<SaleDetailResponse> entitiesToEntityDTOs(List<SaleDetail> entities);

  @AfterMapping
  protected void addLinks(@MappingTarget SaleDetailResponse resource, SaleDetail entity) {
    Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(SaleDetailController.class).getSaleDetailById(entity.getId())).withSelfRel();
    resource.add(selfLink);

    // Aquí puedes añadir más enlaces HATEOAS según sea necesario
  }
}


package com.ada.facturationsystem.controller.api.mapper.response;

import com.ada.facturationsystem.controller.ProductController;
import com.ada.facturationsystem.controller.api.dto.response.ProductResponse;
import com.ada.facturationsystem.domain.models.entity.Product;
import org.mapstruct.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Mapper(componentModel = "spring")
public abstract class ProductResponseMapper implements RepresentationModelAssembler<Product, ProductResponse> {

  @Override
  @Mappings({@Mapping(source = "id", target = "id")})
  public abstract ProductResponse toModel(Product entity);

  public abstract List<ProductResponse> entitiesToEntityDTOs(List<Product> entities);

  @AfterMapping
  protected void addLinks(@MappingTarget ProductResponse resource, Product entity) {
    Link selfLink = linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(entity.getId())).withSelfRel();
    resource.add(selfLink);

    // Aquí puedes añadir más enlaces HATEOAS según sea necesario
  }
}


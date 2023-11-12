package com.ada.facturationsystem.controller.api.mapper.request;

import com.ada.facturationsystem.controller.api.dto.request.SaleDetailRequest;
import com.ada.facturationsystem.controller.api.dto.request.SaleRequest;
import com.ada.facturationsystem.domain.models.entity.Product;
import com.ada.facturationsystem.domain.models.entity.Sale;
import com.ada.facturationsystem.domain.models.entity.Seller;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Mapper to convert SaleRequest DTO to Sale entity.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        builder = @Builder(disableBuilder = true))
public abstract class SaleRequestMapper {

  /**
   * Converts a SaleRequest DTO to a Sale entity.
   *
   * @param dto the DTO to create a Sale record
   * @return the Sale entity
   */
  public abstract Sale toEntity(SaleRequest dto);

  // Cualquier lógica adicional después de mapear los campos básicos
  @AfterMapping
  protected void afterMapping(SaleRequest dto, @MappingTarget Sale entity) {
    Seller seller = new Seller();
    seller.setId(dto.getSellerId());
    entity.setSeller(seller);

  /*  Product product;
    List<Product> products = new ArrayList<Product>();
    for (SaleDetailRequest item: dto.getSaleDetails()) {
      product = new Product();
      product.setId(item.getId());
      products.add(product);
    }
    entity.setSaleDetails();
   */
  }
}
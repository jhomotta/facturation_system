package com.ada.facturationsystem.domain.models.entity;

import com.ada.facturationsystem.domain.models.BaseAuditory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * Detalle específico dentro de una venta
 */
@Entity
@Table(name ="sale_details")
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class SaleDetail extends BaseAuditory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  private Integer quantity; // Este campo almacena la cantidad del producto vendido en esa transacción específica.
  private Double price; // Precio al momento de la venta

  @ManyToOne
  @JoinColumn(name = "sale_id")
  private Sale sale;

  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

}

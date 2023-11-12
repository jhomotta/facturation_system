package com.ada.facturationsystem.domain.models.entity;

import com.ada.facturationsystem.domain.models.BaseAuditory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * registrar el stock disponible de cada producto.
 */
@Entity
@Table(name ="inventory")
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Inventory extends BaseAuditory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  private Product product;
  private Integer quantity; // Cantidad de producto en inventario

}

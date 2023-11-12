package com.ada.facturationsystem.domain.models.entity;

import com.ada.facturationsystem.domain.models.BaseAuditory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * almacenar información de cada producto.
 */

@Entity
@Table(name ="products")
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Product extends BaseAuditory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "price", nullable = false)
  private double price;
}

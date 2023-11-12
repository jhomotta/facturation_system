package com.ada.facturationsystem.domain.models.entity;

import com.ada.facturationsystem.domain.models.BaseAuditory;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

/**
 * almacenar información de los vendedores.
 */
@Entity
@Table(name ="sellers")
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Seller extends BaseAuditory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  private String name;
}

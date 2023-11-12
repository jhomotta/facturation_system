package com.ada.facturationsystem.domain.models.entity;

import com.ada.facturationsystem.domain.models.BaseAuditory;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

/**
 * guardar detalles de cada venta, incluyendo el producto, cantidad, y precio.
 */
@Entity
@Table(name ="sales")
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Sale extends BaseAuditory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;

  @ManyToOne
  private Seller seller;

  @OneToMany(mappedBy = "sale")
  private List<SaleDetail> saleDetails;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Transient
  private Double totalSale = Double.valueOf(0);

  @PostLoad
  private void calculateTheTotalOfTheSale() {
    double totalSale = 0;
    for (SaleDetail detail : this.getSaleDetails()) {
      Integer quantity = detail.getQuantity();
      if (quantity != null) {
        totalSale += quantity * detail.getPrice();
      }
    }
    this.totalSale = totalSale;
  }

}

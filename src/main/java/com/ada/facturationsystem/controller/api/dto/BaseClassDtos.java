package com.ada.facturationsystem.controller.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public abstract class BaseClassDtos<T extends RepresentationModel<? extends T>> extends RepresentationModel<T> {

  @Schema(description = "Unique identifier of the DTO.", example = "1")
  private Long id;

  @Schema(description = "Creation date of the DTO.")
  private Instant creationDate;

  @Schema(description = "Last modified date of the DTO.")
  private Instant lastModifiedDate;
}
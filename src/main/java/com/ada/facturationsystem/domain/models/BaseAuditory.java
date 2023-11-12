package com.ada.facturationsystem.domain.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder
public abstract class BaseAuditory {

  @CreatedDate
  @Column(name = "created_date", updatable = false)
  private Instant creationDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  private Instant lastModifiedDate;
}

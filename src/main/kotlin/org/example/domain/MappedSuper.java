package org.example.domain;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class MappedSuper {
  @Id
  private Long id = 0L;

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }
}

package com.example.demo.entity;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "test")
public class TestEntity {
  @Id
  @Column(name = "id")
  public Long id;
}

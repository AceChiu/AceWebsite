package com.ace.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

/**
 * @author: ACE.CHIU
 * @create: 2023-10-24
 */
@Entity
public class Label extends BaseEntity {
  @Getter
  @Setter
  private String labelname;
}

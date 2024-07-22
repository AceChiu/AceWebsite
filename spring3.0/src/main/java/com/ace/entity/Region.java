package com.ace.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;

/**
 * @author: ACE.CHIU
 * @create: 2023-06-08
 */
@Entity
public class Region extends BaseEntity {

  @Getter
  @Setter
  private String city;
  
  @Getter
  @Setter
  private String district;
  
}

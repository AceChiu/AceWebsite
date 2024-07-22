package com.ace.resource;

import com.ace.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * @author: ACE.CHIU
 * @create: 2021-02-23
 */
public abstract class BaseEntityResource<T extends BaseEntity>  {

  public abstract String getResourceType();

  @JsonIgnore
  public abstract T getEntity();

  @JsonProperty("uuid")
  public String getObjectId() {
    return getEntity().getUuid();
  }
}
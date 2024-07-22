package com.ace.resource;

import com.ace.entity.UserProfile;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;

public class UserProfileResource extends BaseEntityResource<UserProfile> {

  @JsonInclude(JsonInclude.Include.NON_NULL)
  @JsonUnwrapped
  @Setter
  @Getter
  private UserProfile entity;
  
  @Override
  public String getResourceType() {
    return UserProfile.class.getSimpleName();
  }
}

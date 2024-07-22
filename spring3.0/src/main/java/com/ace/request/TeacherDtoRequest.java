package com.ace.request;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: ACE.CHIU
 * @create: 2023-03-19
 */
@Getter
@Setter
public class TeacherDtoRequest {
  
  private String googleId;
  private String email;
  private String uuid;
  private String imgUrl;
  private String skill;
  private String experience;
}

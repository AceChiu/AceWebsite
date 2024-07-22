package com.ace.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author: ACE.CHIU
 * @create: 2023-03-23
 */
@Data
public class CourseDto {
  private long id;
  private String imgUrl;
  private String content;
  private LocalDateTime time;
  private int studentLimit;
  private String address;
}

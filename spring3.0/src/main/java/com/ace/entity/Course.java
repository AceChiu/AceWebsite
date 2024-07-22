package com.ace.entity;

import com.ace.common.CourseTypeEnum;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author: ACE.CHIU
 * @create: 2022-07-03
 */
@Entity
public class Course extends BaseEntity {

  private static final long serialVersionUID = -5103435175697067139L;
  
  @Getter
  @Setter
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Teacher teacher;
  
  @Getter
  @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = Student_.COURSES)
  private List<Student> students;
  
  @Getter
  @Setter
  private String imgUrl; 
  
  @Getter
  @Setter
  private String content;
  
  /*
   * Calender
   */
  
  @Getter
  @Setter
  private int studentLimit;
  
  @Getter
  @Setter
  private String address;
  
  @Getter
  @Setter
  private CourseTypeEnum courseType;
  
  @Getter
  @Setter
  @OneToMany
  private List<Label> label;
 
  @Getter
  @Setter
  private BigDecimal money;
  
  /*
   * 還需要有一個付款的 Table
   */
}

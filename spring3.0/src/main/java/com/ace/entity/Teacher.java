package com.ace.entity;

import com.ace.common.ClarifyEnum;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

/**
 * @author: ACE.CHIU
 * @create: 2022-07-03
 */
@Entity
public class Teacher extends BaseEntity {
  private static final long serialVersionUID = -66606257433452604L;

  @Getter
  @Setter
  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  @JoinColumn(name = UserProfile_.ID, unique = true)
  private UserProfile userProfile;

  @Getter
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = Course_.TEACHER)
  private List<Course> courses;
  
  @Getter
  @Setter
  private String imgUrl;  
  
  @Getter
  @Setter
  private String selfIntroduction;
  
  @Getter
  @Setter
  private String partOfCompany; 
  
  @Getter
  @Setter
  private String suitAgeFrom; 

  @Getter
  @Setter
  private String suitAgeTo; 
  
  @Getter
  @Setter
  @OneToMany
  private List<Label> label;
  
  /*
   *  尚未認證，測試中，驗證成功
   *  測試中可以開課，但只能開體驗課
   *  驗證成功，所有客都可以開
   */
  
  @Getter
  @Setter
  private ClarifyEnum clarify;
}

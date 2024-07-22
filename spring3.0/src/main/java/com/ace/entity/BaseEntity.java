package com.ace.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
/**
 * @author: ACE.CHIU
 * @create: 2020-03-18
 */
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = 4825301256750350895L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  @Setter
  protected Long id;

  @Getter
  @Setter
  protected String uuid = UUID.randomUUID().toString();

  @Getter
  @Setter
  @Version
  protected Long updateCount;  

  @CreatedDate
  @Getter
  @Setter
  protected LocalDateTime created;

  @LastModifiedDate
  @Getter
  @Setter
  protected LocalDateTime lastModified;

  @CreatedBy
  @Getter
  @Setter
  protected String createdBy;   

  @LastModifiedBy
  @Getter
  @Setter
  protected String lastModifiedBy; 
}

package com.ace.common;

import lombok.Getter;

/**
 * @author: ACE.CHIU
 * @create: 2023-03-23
 */
public enum ClarifyEnum {
  PROCESSING("尚未驗證"), 
  PENDING("測試中"),
  SUCCESSFUL("驗證成功");
  
  @Getter
  private String status;

  private ClarifyEnum(String status) {
    this.status = status;
  }
}

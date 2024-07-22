package com.ace.common;

import lombok.Getter;

public enum CourseTypeEnum {
    SPORT("Sport", "運動"), ART("Art", "藝術"), LIFE("Life", "生活");
    
    @Getter
    String code;
    
    @Getter
    String name;

    CourseTypeEnum(String code, String name) {
      this.code = code;
      this.name = name;
    }
    
    public static CourseTypeEnum getEnum(String code) {
      for (CourseTypeEnum value : CourseTypeEnum.values()) {
        if (value.getCode().equals(code)) {
          return value;
        }
      }
      return null;
    }

    public static boolean contains(String code) {
      return getEnum(code) != null;
    }
    
    public static String getStrList(String delimiter) {
      StringBuilder sb = new StringBuilder();
      for (CourseTypeEnum value : CourseTypeEnum.values()) {
        sb.append(delimiter + value.getCode());
      }
      return sb.substring(delimiter.length());
    }
}

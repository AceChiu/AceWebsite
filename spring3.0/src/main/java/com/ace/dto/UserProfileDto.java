package com.ace.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: ACE.CHIU
 * @create: 2022-06-30
 */
@Data
@Builder
public class UserProfileDto {
    private long id;
    private String username;
    private String password;

    private String email;
    private String googleId;
    private String name;
    private String familyName;
    private String givenName;

    private String birthday;
    private String phone;
    private String address;
}

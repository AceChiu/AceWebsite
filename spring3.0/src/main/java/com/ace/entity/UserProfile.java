package com.ace.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author: ACE.CHIU
 * @create: 2022-06-30
 */
@Entity
@Data
public class UserProfile extends BaseEntity {

    private static final long serialVersionUID = 3138912709489043965L;
    private String username;
    private String password;

    private String email;
    private String googleId;
    private String lindId;
    private String igId;

    private String name;
    private String familyName;
    private String givenName;

    private String birthday;
    private String phone;
    private String address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = Student_.USER_PROFILE)
    private Student student;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = Teacher_.USER_PROFILE)
    private Teacher teacher;

    @Getter
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles = new ArrayList<>();
}

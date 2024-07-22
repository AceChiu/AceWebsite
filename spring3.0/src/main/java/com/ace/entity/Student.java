package com.ace.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.List;


/**
 * @author: ACE.CHIU
 * @create: 2023-03-19
 */
@Entity
public class Student extends BaseEntity {

    private static final long serialVersionUID = 1651345380729541023L;

    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = UserProfile_.ID, unique = true)
    private UserProfile userProfile;

    @Getter
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
//    @JoinTable(joinColumns = {@JoinColumn(name = Student_.ID, referencedColumnName = Student_.ID)},
//            inverseJoinColumns = {@JoinColumn(name = Course_.ID, referencedColumnName = Course_.ID)})
    private List<Course> courses;

    @Getter
    @Setter
    private String school;

    @Getter
    @Setter
    private String guardianName;

    @Getter
    @Setter
    private String guardianPhone;

    @Getter
    @Setter
    private String guardianEmail;

    @Getter
    @Setter
    private Region region;

}

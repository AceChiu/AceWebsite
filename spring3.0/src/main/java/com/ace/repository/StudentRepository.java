package com.ace.repository;

import com.ace.entity.Student;
import com.ace.entity.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: ACE.CHIU
 * @create: 2022-07-03
 */
@Repository
public interface StudentRepository extends BasicJpaRepository<Student> {
  Optional<Student> findByUserProfile(UserProfile userProfile);
}

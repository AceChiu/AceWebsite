package com.ace.repository;

import com.ace.entity.Course;
import org.springframework.stereotype.Repository;

/**
 * @author: ACE.CHIU
 * @create: 2022-07-03
 */
@Repository
public interface CourseRepository extends BasicJpaRepository<Course> {
//  Optional<Teacher> findByUserProfile(UserProfile userProfile);
}

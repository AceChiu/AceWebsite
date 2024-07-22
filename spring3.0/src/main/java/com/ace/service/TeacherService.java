
package com.ace.service;

import com.ace.entity.Teacher;
import com.ace.entity.UserProfile;
import com.ace.exception.BusinessException;
import com.ace.repository.BasicJpaRepository;
import com.ace.repository.TeacherRepository;
import com.ace.request.TeacherDtoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: ACE.CHIU
 * @create: 2021-02-22
 */
@Service
public class TeacherService extends BasicService<Teacher> {
  
  @Autowired
  private UserProfileService userProfileService;

  @Autowired
  private TeacherRepository repository;

  @Override
  public BasicJpaRepository<Teacher> getRepository() {
    return repository;
  }
  
  public Teacher create(TeacherDtoRequest request) {
    UserProfile userProfile = userProfileService.findByEmail(request.getEmail());
    Teacher teacher = new Teacher();
    teacher.setUserProfile(userProfile);
    teacher.setImgUrl(request.getImgUrl());
    return repository.save(teacher);
  }
  
  public Teacher update(TeacherDtoRequest request) {
    Optional<Teacher> teacherOpt = repository.findByUuid(request.getUuid());
    if (!teacherOpt.isPresent()) {
      throw new BusinessException("Teacher Could not Find");
    } 
    Teacher teacher = teacherOpt.get();
    teacher.setImgUrl(request.getImgUrl());
    return repository.save(teacher);
  }
}

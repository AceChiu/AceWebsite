package com.ace.service;

import com.ace.entity.Student;
import com.ace.repository.BasicJpaRepository;
import com.ace.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ACE.CHIU
 * @create: 2021-03-19
 */
@Service
public class StudentService extends BasicService<Student> {

  @Autowired
  private StudentRepository repository;

  @Override
  public BasicJpaRepository<Student> getRepository() {
    return repository;
  }
}

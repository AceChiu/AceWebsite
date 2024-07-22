package com.ace.api;

import com.ace.common.ResourcePaths;
import com.ace.entity.Teacher;
import com.ace.request.TeacherDtoRequest;
import com.ace.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ACE.CHIU
 * @create: 2022-08-16
 */

@RestController
@RequestMapping("/api/" + ResourcePaths.TEACHER)
public class TeacherController {
  
  @Autowired
  private TeacherService teacherService;

  @PostMapping(value = "/create")
  public Teacher create(@RequestBody TeacherDtoRequest request) {
    return teacherService.create(request);
  }

  @PostMapping(value = "/update")
  public Teacher update(@RequestBody TeacherDtoRequest request) {
    return teacherService.update(request);
  }
}

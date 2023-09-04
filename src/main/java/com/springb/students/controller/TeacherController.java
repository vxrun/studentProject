package com.springb.students.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.bean.TeacherBean;
import com.springb.students.entity.Teacher;
import com.springb.students.service.TeacherService;

@RestController
public class TeacherController {
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(path = "/registerTeacher", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('GUEST')")
	public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherBean teacherBean) {

		System.out.println(teacherBean.toString());
		Teacher teacher = new Teacher();
		
		BeanUtils.copyProperties(teacherBean, teacher);
		System.out.println(teacher.toString());
		return ResponseEntity.ok().body(teacher);
	}
}

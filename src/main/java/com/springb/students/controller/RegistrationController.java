package com.springb.students.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.bean.StudentBean;
import com.springb.students.bean.TeacherBean;
import com.springb.students.entity.Student;
import com.springb.students.entity.Teacher;
import com.springb.students.service.StudentService;
import com.springb.students.service.TeacherService;

@RestController
public class RegistrationController {
	
	/*
	 * REGISTRATION OF USER
	 */
	
	@Autowired
	TeacherService teacherService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@RequestMapping(path = "/registerTeacher", method = RequestMethod.POST)
	public ResponseEntity<Teacher> createTeacher(@RequestBody TeacherBean teacherBean) {
		teacherBean.setPassword(passwordEncoder.encode(teacherBean.getPassword()));
		
		System.out.println(teacherBean.toString());
		
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(teacherBean, teacher);
		teacherService.saveTeacher(teacher);
		System.out.println(teacher.toString());
		
		return ResponseEntity.ok().body(teacher);
	}

	@RequestMapping(path = "/registerStudent", method = RequestMethod.POST)
	public ResponseEntity<Student> createStudent(@RequestBody StudentBean studentBean) {	
		studentBean.setPassword(passwordEncoder.encode(studentBean.getPassword()));
		Student student = new Student();
		BeanUtils.copyProperties(studentBean, student);
		studentService.saveStudent(student);
		System.out.println(student.toString());
		
		return ResponseEntity.ok().body(student);
	}
	
	
	
	
}

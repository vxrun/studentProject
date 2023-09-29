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
import com.springb.students.cache.CacheUtils;
import com.springb.students.entity.Student;
import com.springb.students.entity.Teacher;
import com.springb.students.exceptions.UserAlreadyExistsException;
import com.springb.students.service.StudentService;
import com.springb.students.service.TeacherService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class RegistrationController {
	
	/*
	 * REGISTRATION OF USER
	 */
	
	@Autowired
	private CacheUtils cacheUtils;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(path = "/registerTeacher", method = RequestMethod.POST)
	public ResponseEntity<String> createTeacher(@RequestBody TeacherBean teacherBean) {
		log.info("*********Called Teacher Registration Method**********");
		
		if(cacheUtils.checkEmailExist(teacherBean.getEmail())) {
			throw new UserAlreadyExistsException();
		}
		
		teacherBean.setPassword(passwordEncoder.encode(teacherBean.getPassword()));
		
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(teacherBean, teacher);
		teacherService.saveTeacher(teacher);
		log.info("*********New Teacher Details: {}************", teacher.toString());
		
		return ResponseEntity.ok().body("Registration successful. The user(teacher) details are"
				+ " as follows : \n "
				+ teacher.toString());
	}

	@RequestMapping(path = "/registerStudent", method = RequestMethod.POST)
	public ResponseEntity<String> createStudent(@RequestBody StudentBean studentBean) {	
		log.info("*********Called Student Registration Method**********");
		
		if(cacheUtils.checkEmailExist(studentBean.getEmail())) {
			throw new UserAlreadyExistsException();
		}
		
		studentBean.setPassword(passwordEncoder.encode(studentBean.getPassword()));
		
		Student student = new Student();
		BeanUtils.copyProperties(studentBean, student);
		studentService.saveStudent(student);
		log.info("*********New Student Details: {}", student.toString());
		
		return ResponseEntity.ok().body(
				"Registration successful. The user(student) details are" +
						" as follows : \n " + 
						student.toString());
	}
	
	
	
	
}

package com.springb.students.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.bean.StudentBean;
import com.springb.students.entity.Student;
import com.springb.students.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;

	@RequestMapping(path = "/registerStudent", method = RequestMethod.POST)
	public ResponseEntity<Student> createStudent(@RequestBody StudentBean studentBean) {
		
		//check if user exists
		/*
		 * String emailString = studentBean.getEmail(); String passwordString =
		 * studentBean.getPassword(); Student student =
		 * studentService.findByEmail(emailString); if(student!=null) { // String
		 * passwordString = bCryptPasswordEncoder.encode(studentBean.getPassword());
		 * studentBean.setPassword(passwordString);
		 * 
		 * Login loginData = new Login(emailString, passwordString);
		 * 
		 * Student student2 = new Student(); BeanUtils.copyProperties(studentBean,
		 * student2); studentService.saveStudent(student2);
		 * System.out.println(student2.toString()); } else {
		 * System.out.println("invalid data"); }
		 */
		
		Student student2 = new Student();
		BeanUtils.copyProperties(studentBean, student2);
		studentService.saveStudent(student2);
		System.out.println(student2.toString());
		
		return ResponseEntity.ok().body(student2);
	}
}

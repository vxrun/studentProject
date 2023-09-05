package com.springb.students.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springb.students.bean.LoginBean;
import com.springb.students.entity.Student;
import com.springb.students.service.StudentService;
import com.springb.students.service.TeacherService;

@RestController
public class LoginController {
	
	/*
	 * LOGIN OF USER
	 */
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@RequestMapping(path="/login",method = RequestMethod.POST)
	public String loginHandler(@RequestBody LoginBean loginBean) {
		String username = loginBean.getEmail();
		String password = passwordEncoder.encode(loginBean.getPassword());

		//check if user exists in student class or not
		Student student = studentService.findByEmail(username);
		
		
		
		
		
		//redirecting to student handler
		
		
		return "Login Successful. Welcome ";
	}
}

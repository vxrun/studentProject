package com.springb.students.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springb.students.entity.Student;
import com.springb.students.entity.Teacher;
import com.springb.students.principal.StudentPrincipal;
import com.springb.students.principal.TeacherPrincipal;

public class UserInfoUserDetailsService implements UserDetailsService{

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Student student = studentService.findByEmail(username);
		if(student!=null) {
			return new StudentPrincipal(student);
		}
		Teacher teacher = teacherService.findByEmail(username);
		if(teacher!=null) {
			return new TeacherPrincipal(teacher);
		}
		return null;
	}

}

package com.springb.students.config.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springb.students.DAO.StudentDAO;
import com.springb.students.entity.Student;
import com.springb.students.entity.Teacher;
import com.springb.students.principal.StudentPrincipal;
import com.springb.students.principal.TeacherPrincipal;
import com.springb.teacher.DAO.TeacherDAO;

public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	StudentDAO studentDAO;
	
	@Autowired
	TeacherDAO teacherDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Student student  = studentDAO.findByEmail(username);
		if(student!=null) {
			return new StudentPrincipal(student);
		}
		Teacher teacher = teacherDAO.findByEmail(username);
		if(teacher!=null) {
			return new TeacherPrincipal(teacher);
		}
		return null;
	}

}

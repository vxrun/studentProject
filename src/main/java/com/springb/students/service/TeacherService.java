package com.springb.students.service;

import java.util.List;

import com.springb.students.entity.Teacher;

public interface TeacherService {
	
	List<Teacher> findTeachersByFirstName(String firstName);

	List<Teacher> findTeachersByLastName(String firstName);

	List<Teacher> showAllTeachers();

	public void createTeacher(String firstName, String lastName, String email, String password, String subject,
			int totalStudents);
	
	public void saveTeacher(Teacher teacher);
	
	public Teacher findByEmail(String email);

}

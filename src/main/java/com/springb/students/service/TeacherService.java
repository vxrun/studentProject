package com.springb.students.service;

import java.util.List;

import com.springb.students.entity.Teacher;

public interface TeacherService {
	List<Teacher> findTeachersByFirstName(String firstName);

	List<Teacher> findTeachersByLastName(String firstName);

	List<Teacher> showAllTeachers();

	public void createTeacher(String firstName, String lastName, int students);
	
	public void saveTeacher(Teacher teacher);

}

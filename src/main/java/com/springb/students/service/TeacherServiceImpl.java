package com.springb.students.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springb.students.entity.Teacher;
import com.springb.teacher.Dao.TeacherDAO;

@Service
public class TeacherServiceImpl implements TeacherService{
	
	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	public List<Teacher> findTeachersByFirstName(String firstName) {
		List<Teacher> outputList = teacherDAO.findByFirstName(firstName);
		return outputList;
	}

	@Override
	public void createTeacher(String firstName, String lastName, int students) {
		Teacher teacher = new Teacher(firstName,lastName,students);
		teacherDAO.save(teacher);
	}
	
	@Override
	public void saveTeacher(Teacher teacher) {
		teacherDAO.save(teacher);
	}

	@Override
	public List<Teacher> findTeachersByLastName(String lastName) {
		List<Teacher> outputList = teacherDAO.findByLastName(lastName);
		return outputList;
	}

	@Override
	public List<Teacher> showAllTeachers() {
		List<Teacher> outputList = teacherDAO.findAll();
		return outputList;
	}

}

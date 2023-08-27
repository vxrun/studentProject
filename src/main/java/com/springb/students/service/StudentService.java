package com.springb.students.service;

import java.util.List;

import com.springb.students.entity.Student;
import com.springb.students.entity.Subject;

public interface StudentService {

	public void saveStudent(Student student);

	public List<Student> findStudentsByFirstName(String name);

	public List<Student> findStudentsByLastName(String name);

	public List<Student> showAllStudents();

	void createStudent(String firstName, String lastName, String email, String password, List<Subject> subjects);

}

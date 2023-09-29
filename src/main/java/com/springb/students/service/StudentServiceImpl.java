package com.springb.students.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springb.students.DAO.StudentDAO;
import com.springb.students.entity.Student;
import com.springb.students.entity.Subject;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public List<Student> findStudentsByFirstName(String name) {
		List<Student> students = studentDAO.findByFirstName(name);
		if (students == null)
			System.out.println("No element found.");
		else
			System.out.println("Element found.");

		return students;
	}

	@Override
	public List<Student> findStudentsByLastName(String name) {
		List<Student> students = studentDAO.findByLastName(name);

		if (students == null)
			System.out.println("No element found.");
		else
			System.out.println("Element found.");

		return students;
	}

	@Override
	public void createStudent(String firstName, String lastName, String email, String password, List<Subject> subjects) {
		
		
		Student student = new Student(firstName, lastName, email, password, subjects);
		studentDAO.save(student);
		
		System.out.println("Student saved successfully.");
	}
	
	public void saveStudent(Student student) {
		studentDAO.save(student);
		System.out.println("Student saved successfully.");
	}

	@Override
	public List<Student> showAllStudents() {
		List<Student> students = studentDAO.findAll();
		return students;
	}

	@Override
	public Student findByRollNo(int rollNo){
		Optional<Student> student = studentDAO.findById(rollNo);
		if(student.isPresent())
			return studentDAO.getById(rollNo);
		return null;
	}

	@Override
	public Student findByEmail(String email) {
		Student student = studentDAO.findByEmail(email);
		return student;
	}

}

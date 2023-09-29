package com.springb.students.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.springb.students.DAO.StudentDAO;
import com.springb.teacher.DAO.TeacherDAO;

@Configuration
public class CacheUtils {
	List<String> allEmails = new ArrayList<>();
	
	public CacheUtils(@Autowired StudentDAO studentDAO,@Autowired TeacherDAO teacherDao) {
		List<String> findAllStudentEmail = studentDAO.findAllEmail();
		allEmails.addAll(findAllStudentEmail);
		
		List<String> allTeacherEmail = teacherDao.getEmails();
		allEmails.addAll(allTeacherEmail);
	}
	
	public boolean checkEmailExist(String email) {
		System.out.println("--------------[" + allEmails);
		return allEmails.contains(email);
	}
}

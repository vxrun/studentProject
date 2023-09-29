package com.springb.teacher.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springb.students.entity.Teacher;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer>{
	
	@Query(value = "select t from Teacher t where t.firstName=:name")
	List<Teacher> findByFirstName(@Param(value = "name") String name);
	
	@Query(value = "select t from Teacher t where t.lastName=:name")
	List<Teacher> findByLastName(@Param(value = "name") String name);
	
	@Query(value = "select t from Teacher t where t.email=:name")
	Teacher findByEmail(@Param(value="name") String name);
	
	@Query("SELECT t.email FROM Teacher t")
	List<String> getEmails();
	
}

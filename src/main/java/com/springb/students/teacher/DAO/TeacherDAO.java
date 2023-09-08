package com.springb.students.teacher.DAO;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springb.students.entity.Teacher;

@Repository
public interface TeacherDAO extends JpaRepository<Teacher, Integer>{
	
	@Query(value = "select and.firstName from Teacher and where firstName=:name")
	List<Teacher> findByFirstName(@Param(value = "name") String name);
	
	@Query(value = "select and.lastName from Teacher and where lastName=:name")
	List<Teacher> findByLastName(@Param(value = "name") String name);
	
	@Query(value = "select and.email from Teacher where email=:name")
	List<Teacher> findByEmail(@Param(value="name") String name);
	
}

package com.springb.students.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springb.students.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	@Query(value = "select s from Student s where s.firstName=:name")
	List<Student> findByFirstName(@Param(value = "name") String name);
	
	@Query(value = "select s from Student s where s.email=:name")
	Student findByEmail(@Param(value="name") String name);
	
	@Query(value = "select s from Student s where s.lastName=:name")
	List<Student> findByLastName(@Param(value = "name") String name);
	
	@Query(value = "select s.email from Student s")
	List<String> findAllEmail();
}

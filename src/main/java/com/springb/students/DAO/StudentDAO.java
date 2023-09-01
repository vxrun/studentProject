package com.springb.students.DAO;

import java.util.List;import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springb.students.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {
	@Query(value = "from Student where firstName=:name")
	List<Student> findByFirstName(@Param(value = "name") String name);
	
	@Query(value = "from Student where email=:name")
	List<Student> findByEmail(@Param(value="name") String name);
	
	@Query(value = "from Student where lastName=:name")
	List<Student> findByLastName(@Param(value = "name") String name);
}

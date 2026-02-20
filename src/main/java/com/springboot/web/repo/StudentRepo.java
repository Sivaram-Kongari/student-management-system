package com.springboot.web.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.springboot.web.model.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

	// Custom Query Methods
	Student findByName(String name);

	// JPQL - Java Persistence Query Language
	@Query(value = "select s from Student s where branch = :branch")
	List<Student> findByBranch(@Param("branch") String branch);

	// NativeQuery = true
	@Query(value = "select * from student where percentage > :percentage", nativeQuery = true)
	List<Student> findByPercentageGreaterThan(@Param("percentage") double percentage);
}
package com.example.SPwithDB.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.SPwithDB.domain.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query(value = "select s.* from student s where s.deleted = 'N' order by s.id asc ",nativeQuery = true)
	List<Student> findWithNoDeleted();
}

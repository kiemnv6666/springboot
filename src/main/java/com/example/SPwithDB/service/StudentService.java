package com.example.SPwithDB.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SPwithDB.domain.Student;
import com.example.SPwithDB.repository.StudentRepository;

@Service("studentservice")
public class StudentService {

	@Autowired
	StudentRepository repo;
	
	public List<Student> ListAll(){
		return repo.findWithNoDeleted();
	};
	
	public void save(Student std) {
		std.setDeleted("N");
		repo.save(std);
	}
	
	public Student get(Long id) {
		return repo.findById(id).get();
	}
	
	public void deleted (Long id) {
		Student edit = new Student();
		edit = repo.findById(id).get();
		edit.setDeleted("Y");
		repo.save(edit);
	}
}

package com.avind.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avind.student.entities.Student;
import com.avind.student.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;

	@Override
	public Student savestudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student updatestudent(Student student) {
		return repository.save(student);
		
	}

	@Override
	public void deletestudent(Student student) {
         repository.delete(student);
	}

	@Override
	public Student getstudentById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Student> getAllStudent() {
		return repository.findAll();
	}

}

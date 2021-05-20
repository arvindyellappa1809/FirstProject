package com.avind.student.service;

import java.util.List;

import com.avind.student.entities.Student;

public interface StudentService {

	Student savestudent(Student Student);

	Student updatestudent(Student Student);

	void deletestudent(Student Student);

	Student getstudentById(int id);

	List<Student> getAllStudent();

}

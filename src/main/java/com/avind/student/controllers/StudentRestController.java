package com.avind.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avind.student.entities.Student;
import com.avind.student.repos.StudentRepository;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/students")
public class StudentRestController {
	@Autowired
	StudentRepository studentrepo;

	@GetMapping
	public List<Student> getAllStudent() {
		return studentrepo.findAll();
	}	
		@PostMapping
		public Student savestudent(@RequestBody Student student) {
			return studentrepo.save(student);
			
		}
			@PutMapping
			public Student updatestudent(@RequestBody Student student) {
				return studentrepo.save(student);
			}
			
			@DeleteMapping("/{id}")
			public void deletestudent(@PathVariable("id") int id) {
				studentrepo.deleteById(id);
			}

			@GetMapping("/{id}")
			public Student getstudentById(@PathVariable("id") int id) {
				return studentrepo.findById(id).get();
			}
	
}
 
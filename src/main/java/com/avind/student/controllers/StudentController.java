package com.avind.student.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.avind.student.entities.Student;
import com.avind.student.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService service;

	@RequestMapping("/showcreate")
	public String showcreate() {
		return "CreateStudent";
	}

	@RequestMapping("/savestudent")
	public String savestudent(@ModelAttribute("student") Student student, ModelMap modelMap) {
		Student saveStudent = service.savestudent(student);
		String msg = "Student is saved :" + saveStudent.getId();
		modelMap.addAttribute("msg", msg);
		return "CreateStudent";
	}

	@RequestMapping("/displayStudents")
	public String displayStudents(ModelMap modelMap) {
		List<Student> allStudents = service.getAllStudent();
		modelMap.addAttribute("allStudents", allStudents);
		return "displayStudents";
	}

	@RequestMapping("/goBack")
	public String goBack(ModelMap modelMap) {
		return "createStudent";
	}

	@RequestMapping("deleteStudent")
	public String deleteStudent(@RequestParam("id") int id, ModelMap modelMap) {
		Student studentId = service.getstudentById(id);
		service.deletestudent(studentId);
		List<Student> allStudents = service.getAllStudent();
		modelMap.addAttribute("allStudents", allStudents);
		return "displayStudents";
	}
 
	@RequestMapping("/showStudent")
	public String showStudent(@RequestParam("id") int id, ModelMap modelMap) {
		Student student2 = service.getstudentById(id);
		modelMap.addAttribute("student2", student2);
		return "updateStudent";
	}

	@RequestMapping("/updateStud")
	public String updateStudent(@ModelAttribute("student") Student student, ModelMap modelMap) {
		service.updatestudent(student);
		List<Student> allStudents = service.getAllStudent();
		modelMap.addAttribute("allStudents", allStudents);
		return "displayStudents";
	}
}
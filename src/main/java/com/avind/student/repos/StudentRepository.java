package com.avind.student.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avind.student.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}

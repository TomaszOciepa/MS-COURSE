package com.Mango.StudentService.repository;

import com.Mango.StudentService.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

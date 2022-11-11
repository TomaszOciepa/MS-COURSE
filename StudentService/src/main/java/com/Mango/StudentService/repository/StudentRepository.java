package com.Mango.StudentService.repository;

import com.Mango.StudentService.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);
    List<Student> findAllByStatus(Student.Status status);
}

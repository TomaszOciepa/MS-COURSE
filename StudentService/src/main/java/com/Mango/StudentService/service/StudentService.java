package com.Mango.StudentService.service;

import com.Mango.StudentService.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> gestStudents();

    Student getStudent(Long id);
    Student addStudent(Student student);

    void deleteStudent(Long id);

    Student putStudent(Long id, Student student);

    Student patchStudent(Long id, Student student);
}

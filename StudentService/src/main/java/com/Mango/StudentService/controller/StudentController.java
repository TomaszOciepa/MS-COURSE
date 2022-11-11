package com.Mango.StudentService.controller;

import com.Mango.StudentService.model.Student;
import com.Mango.StudentService.service.StudentService;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

//    required = false; oznacza, że parametr nie jest wymagany
    @GetMapping
    public List<Student> getStudents(@RequestParam(required = false) Student.Status status) {

        return studentService.getStudents(status);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }
    @PostMapping
    public Student addStudent(@RequestBody @Valid Student student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public Student putStudent(@PathVariable Long id, @Valid @RequestBody Student student) {
        return studentService.putStudent(id, student);
    }

    @PatchMapping("/{id}")
    public Student patchStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.patchStudent(id, student);
    }

}


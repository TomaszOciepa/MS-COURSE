package com.Mango.StudentService.service;

import com.Mango.StudentService.exception.StudentError;
import com.Mango.StudentService.exception.StudentException;
import com.Mango.StudentService.model.Student;
import com.Mango.StudentService.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public List<Student> getStudents(Student.Status status)
    {
        if(status!=null){
            return studentRepository.findAllByStatus(status);
        }
        return studentRepository.findAll();
    }

    public Student getStudent(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
    }
    @Override
    public Student addStudent(Student student) {
        validateStudentEmailExists(student);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
        student.setStatus(Student.Status.INACTIVE);
        studentRepository.save(student);
    }

    @Override
    public Student putStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(studentFromDb -> {
                    validateStudentEmailExists(student);
                    studentFromDb.setFirstName(student.getFirstName());
                    studentFromDb.setLastName(student.getLastName());
                    studentFromDb.setEmail(student.getEmail());
                    return studentRepository.save(studentFromDb);
                }).orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
    }

    private void validateStudentEmailExists(Student student) {
        if(studentRepository.existsByEmail(student.getEmail())){
            throw new StudentException(StudentError.STUDENT_EMAIL_ALREADY_EXISTS);
        }
    }

    @Override
    public Student patchStudent(Long id, Student student) {
        return studentRepository.findById(id)
                .map(studentFromDb -> {
                    if (!StringUtils.isEmpty(student.getFirstName())) {
                        studentFromDb.setFirstName(student.getFirstName());
                    }
                    if (!StringUtils.isEmpty(student.getLastName())) {
                        studentFromDb.setLastName(student.getLastName());
                    }
                    return studentRepository.save(studentFromDb);
                }).orElseThrow(() -> new StudentException(StudentError.STUDENT_NOT_FOUND));
    }
}

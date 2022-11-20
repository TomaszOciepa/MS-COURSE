package com.tom.courses.Service;

import com.tom.courses.model.dto.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "student-service", path ="/students")
//@RequestMapping("/students")
public interface StudentServiceClient {

    @GetMapping("/{studentId}")
    Student getStudentById(@PathVariable Long studentId);


}
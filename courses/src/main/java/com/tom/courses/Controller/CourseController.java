package com.tom.courses.Controller;

import com.tom.courses.Service.CourseService;
import com.tom.courses.model.Course;
import com.tom.courses.model.dto.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(@RequestParam(required = false) Course.Status status) {
        return courseService.getCourses(status);
    }

    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @GetMapping("/{code}")
    public Course getCourse(@PathVariable String code) {
        return courseService.getCourse(code);
    }

    @PostMapping("/{courseCode}/student/{studentId}")
    public ResponseEntity<?> courseEnrollment(@PathVariable String courseCode, @PathVariable Long studentId){
        courseService.courseEnrollment(courseCode, studentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{code}/members")
    public List<StudentDto> getCourseMembers(@PathVariable String code){
        return courseService.getCourseMembers(code);
    }

    @PostMapping("/{code}/finish-enroll")
    public ResponseEntity<?> courseFinishEnroll(@PathVariable String code){
        courseService.courseFinishEnroll(code);
        return ResponseEntity.ok().build();
    }
}

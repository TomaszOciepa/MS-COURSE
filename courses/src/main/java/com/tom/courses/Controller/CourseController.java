package com.tom.courses.Controller;

import com.tom.courses.Service.CourseService;
import com.tom.courses.model.Course;
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
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{code}")
    public Course getCourse(@PathVariable String code) {
        return courseService.getCourse(code);
    }

    @PostMapping
    public Course addCourse(@Valid @RequestBody Course course) {
        return courseService.addCourse(course);
    }

}

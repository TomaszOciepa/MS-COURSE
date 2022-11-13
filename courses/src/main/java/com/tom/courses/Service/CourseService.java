package com.tom.courses.Service;

import com.tom.courses.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course getCourse(String code);

    Course addCourse(Course course);

}

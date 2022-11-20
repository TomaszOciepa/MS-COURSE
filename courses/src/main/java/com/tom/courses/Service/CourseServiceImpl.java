package com.tom.courses.Service;

import com.tom.courses.exceptions.CourseError;
import com.tom.courses.exceptions.CourseException;
import com.tom.courses.model.Course;
import com.tom.courses.model.CourseMember;
import com.tom.courses.model.dto.Student;
import com.tom.courses.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentServiceClient studentServiceClient;

    public CourseServiceImpl(CourseRepository courseRepository, StudentServiceClient studentServiceClient) {
        this.courseRepository = courseRepository;
        this.studentServiceClient = studentServiceClient;
    }

    @Override
    public List<Course> getCourses(Course.Status status) {
        if (status != null) {
            return courseRepository.findAllByStatus(status);
        }
        return courseRepository.findAll();
    }

    @Override
    public Course getCourse(String code) {
        return courseRepository.findById(code)
                .orElseThrow(() -> new CourseException(CourseError.COURSE_NOT_FOUND));
    }

    @Override
    public Course addCourse(Course course) {
        course.validateCourse();
        return courseRepository.save(course);
    }

    @Override
    public void courseEnrollment( String courseCode, Long studentId) {
        Course course = getCourse(courseCode);
        validateCourseStatus(course);
        Student student = studentServiceClient.getStudentById(studentId);
        validateStudentBeforeCourseEnrollment(course, student);
        course.incrementParticipantsNumber();
        course.getCourseMembers().add(new CourseMember(student.getEmail()));
        courseRepository.save(course);
    }

    private void validateStudentBeforeCourseEnrollment(Course course, Student student) {
        if (!Student.Status.ACTIVE.equals(student.getStatus())) {
            throw new CourseException(CourseError.STUDENT_IS_NOT_ACTIVE);
        }

        if (course.getCourseMembers().stream()
                .anyMatch(member -> student.getEmail().equals(member.getEmail()))) {
            throw new CourseException(CourseError.STUDENT_AlREADY_ENROLLED);

        }
    }

    private void validateCourseStatus(Course course) {
        if (!Course.Status.ACTIVE.equals(course.getStatus())) {
            throw new CourseException(CourseError.COURSE_IS_NOT_ACTIVE);
        }
    }
}

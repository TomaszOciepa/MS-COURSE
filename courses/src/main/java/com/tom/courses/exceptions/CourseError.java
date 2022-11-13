package com.tom.courses.exceptions;

public enum CourseError {

    COURSE_NOT_FOUND("Course does not exists");
    private String message;
    CourseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

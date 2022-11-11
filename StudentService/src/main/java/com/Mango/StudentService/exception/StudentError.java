package com.Mango.StudentService.exception;

public enum StudentError {

    STUDENT_NOT_FOUND("Student does not exists"),
    STUDENT_EMAIL_ALREADY_EXISTS("Student email already exists");

    private String message;
    StudentError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

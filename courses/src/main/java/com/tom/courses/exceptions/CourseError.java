package com.tom.courses.exceptions;

public enum CourseError {

    COURSE_NOT_FOUND("Course does not exists"),
    COURSE_START_DATE_IS_AFTER_END_DATE("Course start date is after end date"),
    COURSE_PARTICIPANTS_LIMIT_IS_EXCEEDED("Course participants limit is exceeded"),
    COURSE_CAN_NOT_SET_FULL_STATUS("Course can not set Full status"),
    COURSE_CAN_NOT_SET_ACTIVE_STATUS("Course can not set Active status"),
    COURSE_IS_NOT_ACTIVE("Course is not Active"),
    STUDENT_IS_NOT_ACTIVE("Student is not Active"),
    STUDENT_AlREADY_ENROLLED("Student already enrolled");

    private String message;

    CourseError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

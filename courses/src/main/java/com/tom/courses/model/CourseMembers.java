package com.tom.courses.model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class CourseMembers {

    @NotNull
    private LocalDateTime enrollmentData;
    @NotNull
    private String email;

    public CourseMembers(@NotNull String email) {
        this.enrollmentData = LocalDateTime.now();
        this.email = email;
    }
}

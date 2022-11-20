package com.tom.courses.model;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
public class CourseMember {

    @NotNull
    private LocalDateTime enrollmentData;
    @NotNull
    private String email;

    public CourseMember(@NotNull String email) {
        this.enrollmentData = LocalDateTime.now();
        this.email = email;
    }
}

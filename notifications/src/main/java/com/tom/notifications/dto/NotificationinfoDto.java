package com.tom.notifications.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
@Setter
@ToString
public class NotificationinfoDto {

    private List<String> emails;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime courseStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime courseEndDate;



}

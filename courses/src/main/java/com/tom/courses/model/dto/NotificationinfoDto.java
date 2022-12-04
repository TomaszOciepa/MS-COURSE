package com.tom.courses.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Document
@Getter
@Setter
public class NotificationinfoDto {

    private List<String> emails;
    private String courseCode;
    private String courseName;
    private String courseDescription;
    @JsonFormat(pattern = "yyyy-MM-dd 'T'HH:mm")
    private LocalDateTime courseStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd 'T'HH:mm")
    private LocalDateTime courseEndDate;


}

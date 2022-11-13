package com.tom.courses.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Document
public class Course {

    @Id
    private String code;
    @NotBlank
    private String name;
    private String descriptions;
    @NotNull
    @Future
    private LocalDateTime startDate;
    @NotNull
    @Future
    private LocalDateTime endDate;
    @Min(0)
    private Long participantsLimit;
    @NotNull
    @Min(0)
    private Long getParticipantsNumber;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getParticipantsLimit() {
        return participantsLimit;
    }

    public void setParticipantsLimit(Long participantsLimit) {
        this.participantsLimit = participantsLimit;
    }

    public Long getGetParticipantsNumber() {
        return getParticipantsNumber;
    }

    public void setGetParticipantsNumber(Long getParticipantsNumber) {
        this.getParticipantsNumber = getParticipantsNumber;
    }
    
}

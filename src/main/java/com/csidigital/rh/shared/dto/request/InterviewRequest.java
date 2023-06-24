package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.AssQuestionInterview;
import com.csidigital.rh.dao.entity.UpdatedQuestion;
import com.csidigital.rh.shared.enumeration.InterviewLocation;
import com.csidigital.rh.shared.enumeration.InterviewMode;
import com.csidigital.rh.shared.enumeration.InterviewType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class InterviewRequest {

    private LocalDate interviewDate;
    private LocalTime interviewTime;
    private String duration;
    private String comment;
    private Integer globalMark;
    private String interviewerName;
    private String interviewerEmail;
    private String interviewerPhoneNumber;
    private String interviewPlace;
    private InterviewLocation interviewLocation ;
    private InterviewType interviewType;
    private InterviewMode interviewMode;
    private List<AssQuestionInterview> assQuestionInterviewList;
    private List<Long> questionTypeIds;
    private Long evaluationNum;
    private List<UpdatedQuestion> updatedQuestions;

}
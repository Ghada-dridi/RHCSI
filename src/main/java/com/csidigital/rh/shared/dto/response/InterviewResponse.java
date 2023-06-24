package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.AssQuestionInterview;
import com.csidigital.rh.dao.entity.Evaluation;
import com.csidigital.rh.dao.entity.QuestionType;
import com.csidigital.rh.dao.entity.UpdatedQuestion;
import com.csidigital.rh.shared.enumeration.InterviewLocation;
import com.csidigital.rh.shared.enumeration.InterviewMode;
import com.csidigital.rh.shared.enumeration.InterviewType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@Data
public class InterviewResponse {


    private Long Id;
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
    private List<QuestionType> questionTypeList;
    private Evaluation evaluation;
    private List<UpdatedQuestion> updatedQuestions;
}
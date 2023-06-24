package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Interview;
import com.csidigital.rh.shared.enumeration.InterviewType;
import lombok.Data;

@Data
public class UpdatedQuestionResponse {
    private Long Id;
    private Integer mark;
    private String comment;
    private String questionText;
    private Long interviewNum;
}

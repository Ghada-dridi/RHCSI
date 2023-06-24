package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Interview;
import com.csidigital.rh.dao.entity.QuestionCategory;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Data;

import java.util.List;


@Data
public class QuestionTypeResponse {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private List<QuestionCategory> questionCategories;
    private String questionTypeName;
    private List<Interview> interviewList;
}

package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Question;
import com.csidigital.rh.dao.entity.QuestionType;
import com.csidigital.rh.shared.enumeration.ExperienceLevel;
import com.csidigital.rh.shared.enumeration.QuestionnaireType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.List;
@Data
public class QuestionCategoryResponse {
    private Long id ;
    private String name ;
    private List<Question> questions;
    //private List<QuestionType> questionTypeList;
    private Long questionTypeNum;
    @Enumerated(EnumType.STRING)
    private ExperienceLevel level ;
    @Enumerated(EnumType.STRING)
    private QuestionnaireType questionnaireType ;

}

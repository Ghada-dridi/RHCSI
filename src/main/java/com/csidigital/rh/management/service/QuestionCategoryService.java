package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.QuestionCategoryRequest;
import com.csidigital.rh.shared.dto.response.QuestionCategoryResponse;
import com.csidigital.rh.shared.dto.response.QuestionResponse;

import java.util.List;

public interface QuestionCategoryService {
    QuestionCategoryResponse createQuestionCategory(QuestionCategoryRequest request);
    List<QuestionCategoryResponse> getAllQuestionCategories();
    QuestionCategoryResponse getQuestionCategoryById(Long id);
    //QuestionCategoryResponse getQuestionCategoryByQuestionTypeId(Long id);
    List<QuestionResponse> getCategoryQuestions(Long id);

    QuestionCategoryResponse updateQuestionCategory(QuestionCategoryRequest request, Long id);

    void deleteQuestionCategory(Long id);
}

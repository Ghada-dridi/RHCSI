package com.csidigital.rh.management.service;

import com.csidigital.rh.dao.entity.UpdatedQuestion;
import com.csidigital.rh.shared.dto.request.UpdatedQuestionRequest;
import com.csidigital.rh.shared.dto.response.UpdatedQuestionResponse;

import java.util.List;

public interface UpdatedQuestionService {

    UpdatedQuestionResponse createUpdatedQuestion(UpdatedQuestionRequest request);
    List<UpdatedQuestionResponse> getAllUpdatedQuestion();
    UpdatedQuestionResponse getUpdatedQuestionById(Long id);
   // List<UpdatedQuestion> getQuestionsByUpdatedQuestions(Long id) ;

    UpdatedQuestionResponse updateUpdatedQuestion(UpdatedQuestionRequest request, Long id);

    void deleteUpdatedQuestion(Long id);

}

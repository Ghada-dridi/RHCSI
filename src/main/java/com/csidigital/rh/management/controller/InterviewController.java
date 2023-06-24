package com.csidigital.rh.management.controller;

import com.csidigital.rh.management.service.impl.InterviewImpl;

import com.csidigital.rh.shared.dto.request.InterviewRequest;
import com.csidigital.rh.shared.dto.response.InterviewResponse;
import com.csidigital.rh.shared.dto.response.QuestionTypeResponse;
import com.csidigital.rh.shared.dto.response.UpdatedQuestionResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("rh/Interview")

public class InterviewController {
    @Autowired
    private InterviewImpl interviewImpl ;

    @GetMapping("getAll")
    public List<InterviewResponse> getAllInterview() {
        return interviewImpl.getAllInterview();
    }

    @GetMapping("/getBy/{id}")
    public InterviewResponse getInterviewById(@PathVariable Long id){
        return interviewImpl.getInterviewById(id);
    }
    @GetMapping("/get/{id}/questionType")
    public List<QuestionTypeResponse> getQuestionTypesbyInterview(@PathVariable Long id){
        return  interviewImpl.getQuestionTypesbyInterview(id);
    }
    @GetMapping("/get/{id}/updatedQuestion")
    public List<UpdatedQuestionResponse> getUpdatedQuestionsInterview(@PathVariable Long id){
        return interviewImpl.getUpdatedQuestionsInterview(id);
    }
    @PutMapping("addQuestionType/{id}")
    public void addQuestionTypeToInterview(@PathVariable Long id, @RequestBody List<Long> questionTypeIds) {
        interviewImpl.addQuestionTypeToInterview(id,questionTypeIds);
    }

    @PostMapping("/add")
    public InterviewResponse createInterview(@Valid @RequestBody InterviewRequest interviewRequest){
        return interviewImpl.createInterview(interviewRequest);
    }

    @PutMapping("/update/{id}")
    public InterviewResponse updateInterview(@Valid @RequestBody InterviewRequest interviewRequest,
                                             @PathVariable Long id){
        return interviewImpl.updateInterview(interviewRequest, id); }

    @DeleteMapping("/delete/{id}")
    public void deleteInterview(@PathVariable Long id){
        interviewImpl.deleteInterview(id);
    }

    @PutMapping("/updateStatusToPlannedById/{id}")
    void updateStatusToPlannedById(@PathVariable Long id) {
        interviewImpl.updateStatusToPlannedById(id);
    }

    @PutMapping("/updateStatusToEndedById/{id}")
    void updateStatusToEndedById(@PathVariable Long id) {
        interviewImpl.updateStatusToEndedById(id);
    }

    @PutMapping("/updateStatusToCancelledById/{id}")
    void updateStatusToCancelledById(@PathVariable Long id) {
        interviewImpl.updateStatusToCancelledById(id);
    }

}
package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.Interview;
import com.csidigital.rh.dao.entity.OfferCandidate;
import com.csidigital.rh.dao.entity.TechnicalFile;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EvaluationRequest {
    private Double globalAppreciation;
    private List<OfferCandidate>offerCandidates;
    private List<Interview> interviews;
    private LocalDate evaluationDate;
    private Long employeeNum ;

}
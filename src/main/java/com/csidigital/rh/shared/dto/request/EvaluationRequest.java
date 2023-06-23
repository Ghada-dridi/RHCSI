package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.OfferCandidate;
import com.csidigital.rh.dao.entity.TechnicalFile;
import lombok.Data;

import java.util.List;

@Data
public class EvaluationRequest {
    private Integer globalAppreciation;
    private List<OfferCandidate>offerCandidates;
    private Long employeeNum ;

}
package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.AdministrativeData;
import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.Interview;
import com.csidigital.rh.dao.entity.OfferCandidate;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class EvaluationResponse {
    private Long Id ;
    private Double globalAppreciation;
    private List<OfferCandidate> offerCandidates;
    private AdministrativeData administrativeData;
    private Long employeeNum ;
    private LocalDate evaluationDate;
    private List<Interview> interviews ;
}
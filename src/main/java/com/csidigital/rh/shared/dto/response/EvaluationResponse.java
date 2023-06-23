package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.AdministrativeData;
import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.OfferCandidate;
import lombok.Data;

import java.util.List;

@Data
public class EvaluationResponse {
    private Long Id ;
    private Integer globalAppreciation;
    private List<OfferCandidate> offerCandidates;
    private AdministrativeData administrativeData;
    private Long employeeNum ;
}
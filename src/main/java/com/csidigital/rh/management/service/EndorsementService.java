package com.csidigital.rh.management.service;


import com.csidigital.rh.shared.dto.request.EndorsementRequest;
import com.csidigital.rh.shared.dto.request.EvaluationRequest;
import com.csidigital.rh.shared.dto.response.EndorsementResponse;
import com.csidigital.rh.shared.dto.response.EvaluationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EndorsementService {

    EndorsementResponse createEndorsement(EndorsementRequest request);
    List<EndorsementResponse> getAllEndorsements();
    EndorsementResponse getEndorsementById(Long id);

    EndorsementResponse updateEndorsement(EndorsementRequest request, Long id);

    void deleteEndorsement(Long id);
}

package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.CertificationRequest;
import com.csidigital.rh.shared.dto.response.CertificationResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CertificationService {
    CertificationResponse createCertification(CertificationRequest request);
    List<CertificationResponse> getAllCertifications();
    CertificationResponse getCertificationById(Long id);

    CertificationResponse updateCertification(CertificationRequest request, Long id);

    void deleteCertification(Long id);
}

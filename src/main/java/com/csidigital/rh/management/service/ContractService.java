package com.csidigital.rh.management.service;

import com.csidigital.rh.dao.entity.BenefitRC;
import com.csidigital.rh.dao.entity.ExceptionalFee;
import com.csidigital.rh.shared.dto.request.CertificationRequest;
import com.csidigital.rh.shared.dto.request.ContractRequest;
import com.csidigital.rh.shared.dto.response.CertificationResponse;
import com.csidigital.rh.shared.dto.response.ContractResponse;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractService {
    ContractResponse createContract(ContractRequest request);
    List<ContractResponse> getAllContracts();
    ContractResponse getContractById(Long id);

    ContractResponse updateContract(ContractRequest request, Long id);

    void deleteContract(Long id);
    void updateStatusById(Long id, String contractStatus);
    void updateStatusToAcceptedById(Long id);
    void updateStatusToRefusedById(Long id);
    public List<BenefitRC> getContractBenefits(Long id);
    public List<ExceptionalFee> getContractFee(Long id);

    void updateStatusToSentById(Long id);
}

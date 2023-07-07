package com.csidigital.rh.shared.dto.request;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.shared.enumeration.Status;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ContractRequest {

    private LocalDate startDate;
    private LocalDate endDate;
    private String contractTitle;

    private String contractPlace;
    private LocalDate contractDate;
    private Byte[] entrepriseSignature;
    private String commentContract;
    private String contractEmployer;
    private String contractEmployee;
    private  String reference;

    private LocalDate validityDate;

    private List<ArticleUpdated> articles  ;
    private Status contractStatus;
    private List<Endorsement> endorsementList;
    private List<BenefitRC> benefitRCSList;
    private List<ExceptionalFee>  ExceptionalFeeList;
    private Long employeeNum;
}

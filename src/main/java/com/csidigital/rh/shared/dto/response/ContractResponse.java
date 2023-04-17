package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Article;
import com.csidigital.rh.dao.entity.BenefitRC;
import com.csidigital.rh.dao.entity.ExceptionalFee;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ContractResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private LocalDate startDate;
    private String contractTitle;
    private LocalDate endDate;
    private String contractPlace;


    private LocalDate contractDate;
    private Byte[] entrepriseSignature;

    private List<Article> articles ;
    private List<BenefitRC> benefitRCSList;
    private List<ExceptionalFee>  ExceptionalFeeList;
    private Long id_resource;
}

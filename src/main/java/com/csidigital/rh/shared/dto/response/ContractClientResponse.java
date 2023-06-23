package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.ArticleClient;
import com.csidigital.rh.dao.entity.EndorsementClient;
import com.csidigital.rh.shared.enumeration.ContractClientType;
import com.csidigital.rh.shared.enumeration.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class ContractClientResponse {
    private Long id;
    private String titleContract;


    private LocalDate dateContract;

    private String lieuContract;

    private LocalDate startDate;

    private LocalDate endDate;
    private String introductionSoc;

    private String introductionClient;

    private ContractClientType contractType;
    private Status contractStatus;

    private List<ArticleClient>  articleClients;
    private List<EndorsementClient> endorsementClients;
}

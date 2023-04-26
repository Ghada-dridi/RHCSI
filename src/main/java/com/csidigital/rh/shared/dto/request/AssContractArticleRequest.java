package com.csidigital.rh.shared.dto.request;


import lombok.Data;

@Data
public class AssContractArticleRequest {
    private Long articleId;
    private Long contractId;

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}

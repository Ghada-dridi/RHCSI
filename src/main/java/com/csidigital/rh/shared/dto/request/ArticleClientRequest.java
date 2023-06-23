package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.Column;
import lombok.Data;


@Data
public class ArticleClientRequest {



    private Integer articleNumber;

    private String articleTitle;

    private String description;
    private Long contractId;
}

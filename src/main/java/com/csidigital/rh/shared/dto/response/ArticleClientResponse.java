package com.csidigital.rh.shared.dto.response;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ArticleClientResponse {
    private Long id;

    private Integer articleNumber;

    private String articleTitle;

    private String description;
    private Long contractId;

}

package com.csidigital.rh.shared.dto.response;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EndorsementResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "title")
    private String title;
    @Column(name = "nationalBRNumber")
    private String nationalBRNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "endorsementDate")
    private LocalDate endorsementDate;
    @Column(name = "titleNote")
    private String titleNote;
    @Column(name = "note")
    private String note;

}

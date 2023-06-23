package com.csidigital.rh.shared.dto.request;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EndorsementRequest {


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

    private  Long contractNum;
}

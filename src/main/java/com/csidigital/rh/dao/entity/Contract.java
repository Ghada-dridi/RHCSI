package com.csidigital.rh.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contract {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "contractPlace")
    private String contractPlace;

    @Column(name = "contractDate")
    private LocalDate contractDate;
    @Column(name = "startDate")
    private LocalDate startDate;
    @Column(name = "endDate")
    private LocalDate endDate;
    @Column(name = "entrepriseSignature")
    private Byte[] entrepriseSignature;
    @Column(name = "ressourceSignature")
    private Byte[] ressourceSignature;
}

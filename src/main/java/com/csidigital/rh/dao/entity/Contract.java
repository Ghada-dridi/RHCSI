package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Contract {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "contractTitle")
    private String contractTitle;

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


    @JsonIgnore
    @ManyToOne @JoinColumn(name = "id_resource")
    private Resource resource;

    @OneToMany(mappedBy = "contract")
    private List<Article> articles;
    @OneToMany(mappedBy = "contract")
    private List<BenefitRC> benefitRCSList;

    @OneToMany(mappedBy = "contract")
    private List< ExceptionalFee>  ExceptionalFeeList;





}

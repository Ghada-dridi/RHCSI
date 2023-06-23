package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String reference;
    private String type;
    private String designation;
    private LocalDate acquisitionDate;
    private LocalDate endDate;
    private Double purchasePrise;
    private String comment;
    private String supplier;
    private Boolean amortizable;

    private Boolean affectable;
    @Enumerated(EnumType.STRING)
    private Affectation affectation;
    @Enumerated(EnumType.STRING)
    private PurchaseMethod purchaseMethod;
    @Enumerated(EnumType.STRING)
    private AmortizationType amortizationType;

    @Enumerated(EnumType.STRING)
    private StatusDisponibility status;
    @Enumerated(EnumType.STRING)
    private Currency currency;

    private String motifUnavailability;
    private LocalDate disponibilityDate;

    //relation  manytomany avec employee

    @JsonIgnore
    @ManyToMany(mappedBy = "equipmentList")
    private List<Employee> employeeList;



}

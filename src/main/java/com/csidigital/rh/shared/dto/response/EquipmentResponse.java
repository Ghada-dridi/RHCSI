package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.shared.enumeration.*;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EquipmentResponse {
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

    private String supplierOrderNumber;
    private Boolean affectable;
    private LocalDate restituationDate;
    private String restituationStatus;
    @Enumerated(EnumType.STRING)
    private Affectation affectation;
    @Enumerated(EnumType.STRING)
    private PurchaseMethod purchaseMethod;
    @Enumerated(EnumType.STRING)
    private AmortizationType amortizationType;

    private Currency currency;
    @Enumerated(EnumType.STRING)
    private StatusDisponibility status;

    private String motifUnavailability;
    private LocalDate disponibilityDate;



}

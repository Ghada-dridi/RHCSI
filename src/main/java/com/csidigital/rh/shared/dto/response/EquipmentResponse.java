package com.csidigital.rh.shared.dto.response;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class EquipmentResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serialNumber;
    private String type;
    private String resource;
    private LocalDate deliveryDate;
    private String comment;
    private LocalDate returnDate;

}

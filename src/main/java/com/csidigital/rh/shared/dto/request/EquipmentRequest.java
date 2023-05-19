package com.csidigital.rh.shared.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EquipmentRequest {

    private String serialNumber;
    private String type;
    private String resource;
    private LocalDate deliveryDate;
    private String comment;
    private LocalDate returnDate;

}

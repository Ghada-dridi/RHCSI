package com.csidigital.rh.shared.dto.response;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AssEquipmentEmployeeResponse {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;



}

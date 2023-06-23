package com.csidigital.rh.shared.dto.request;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AssEquipmentEmployeeRequest {
    private LocalDate startDate;
    private LocalDate endDate;

    private Long employeeNum ;
    private Long equipmentNum;
}

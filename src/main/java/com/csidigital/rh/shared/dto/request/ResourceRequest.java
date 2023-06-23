package com.csidigital.rh.shared.dto.request;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ResourceRequest extends EmployeeRequest{

    private String serialNumber;
    private String socialSecurityNumber;
    private String bankAccountNumber;
    private Byte[] photo;
    private Double leaveBalanceRest;
    private Double leaveBalance;
    private Long productivity;
    private String nationalIdentity;
    private LocalDate recruitmentDate;
}

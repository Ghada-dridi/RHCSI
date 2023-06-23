package com.csidigital.rh.shared.dto.response;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class ResourceResponse extends EmployeeResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
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

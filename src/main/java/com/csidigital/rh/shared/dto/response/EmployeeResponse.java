package com.csidigital.rh.shared.dto.response;

<<<<<<< HEAD
import com.csidigital.rh.shared.enumeration.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
=======
import com.csidigital.rh.dao.entity.Experience;
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.shared.enumeration.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
>>>>>>> ghada_candidat
import java.util.Set;

@Data
public class EmployeeResponse {
    private Long Id ;
    private String lastName;
    private String firstName;
    private Civility civility;
    private Title title;
    private EmployeeType employeeType;
    private LocalDate birthDate;
    private String emailOne;
    private String emailTwo;
    private Integer phoneNumberOne;
    private Integer phoneNumberTwo;
    private String address;
    private Integer postCode;
    private String city;
<<<<<<< HEAD
    private Country country;
=======
    private String country;
>>>>>>> ghada_candidat
    private MaritalSituation maritalSituation;
    private Integer recommendationMark ;
    private Integer experience ;
    private String experienceDetails ;
    @Enumerated(EnumType.STRING)
    private Provenance provenance;
    private String employeeFirstName;
    private String employeeLastName;
    private String EmployeeSerialNumber;
    private EmployeeStatus employeeStatus;
    @Enumerated(EnumType.STRING)
    private WorkLocation workLocation;


    private String locationName;

    private String serialNumber;

    private Set<Long> offer;
    private Departement departement;
<<<<<<< HEAD
=======
    private TechnicalFile technicalFile ;

    private String  photo;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;
>>>>>>> ghada_candidat
}

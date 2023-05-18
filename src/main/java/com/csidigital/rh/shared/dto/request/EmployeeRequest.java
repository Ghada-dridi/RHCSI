package com.csidigital.rh.shared.dto.request;

<<<<<<< HEAD
=======
import com.csidigital.rh.dao.entity.AdministrativeData;
import com.csidigital.rh.dao.entity.OfferCandidate;
>>>>>>> ghada_candidat
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.shared.enumeration.*;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.time.LocalDate;
<<<<<<< HEAD
=======
import java.util.List;

>>>>>>> ghada_candidat
@Data
public class EmployeeRequest {
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
    private WorkLocation workLocation;
<<<<<<< HEAD
    private String locationName;
=======
>>>>>>> ghada_candidat

    @Enumerated(EnumType.STRING)
    private Provenance provenance;
    private String employeeFirstName;
    private String employeeLastName;
    private String EmployeeSerialNumber;
<<<<<<< HEAD
    private Long AssOfferCandidateId;
=======
    private List<OfferCandidate> AssOfferCandidateList;
>>>>>>> ghada_candidat

    private EmployeeStatus employeeStatus;
    private Departement departement;
    private TechnicalFile technicalFile ;
<<<<<<< HEAD

    private String serialNumber;
}
=======
    private AdministrativeData administrativeData;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

}
>>>>>>> ghada_candidat

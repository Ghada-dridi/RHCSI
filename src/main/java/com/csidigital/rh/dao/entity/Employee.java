package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
<<<<<<< HEAD
=======

>>>>>>> ghada_candidat
    private String lastName;
    @Column(name = "firstName")
    private String firstName;
    @Enumerated(EnumType.STRING)
    private Civility civility;
    @Enumerated(EnumType.STRING)
    private Title title;
    @Enumerated(EnumType.STRING)
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
    @Enumerated(EnumType.STRING)
    private Country country;
=======

    private String country;
>>>>>>> ghada_candidat
    @Enumerated(EnumType.STRING)
    private MaritalSituation maritalSituation;
    private Integer recommendationMark ;
    private Integer experience ;
    private String experienceDetails ;


    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;


    @Enumerated(EnumType.STRING)
    private WorkLocation workLocation;


<<<<<<< HEAD

    @Enumerated(EnumType.STRING)
    private Departement departement;

    private String serialNumber;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "technicalFileId")
    private TechnicalFile technicalFile;
}
=======
    @Enumerated(EnumType.STRING)
    private Departement departement;

    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "employee")
    private TechnicalFile technicalFile;

    @OneToMany(mappedBy = "employee")
    private List<OfferCandidate> offerCandidateList;
    @JsonIgnore
    @OneToOne(mappedBy = "employee")
    private AdministrativeData administrativeData;
}
>>>>>>> ghada_candidat

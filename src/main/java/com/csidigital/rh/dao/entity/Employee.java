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


    private String country;

    @Enumerated(EnumType.STRING)
    private MaritalSituation maritalSituation;

    private Integer recommendationMark ;
    private Integer experience ;
    private String experienceDetails ;


    @Enumerated(EnumType.STRING)
    private EmployeeStatus employeeStatus;
    private String serialNumber;



    @Enumerated(EnumType.STRING)
    private WorkLocation workLocation;


    @Enumerated(EnumType.STRING)
    private Departement departement;


    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL,
            mappedBy = "employee")
    private TechnicalFile technicalFile;


    @JsonIgnore
    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)
    private List<OfferCandidate> offerCandidateList;
    @JsonIgnore
    @OneToOne(mappedBy = "employee" ,cascade = CascadeType.ALL)
    private AdministrativeData administrativeData;
    @JsonIgnore
    @OneToMany(mappedBy = "employee" , cascade = CascadeType.ALL)
    private List<Evaluation> evaluation;


//-------------attributs ResourceInterne--------------------------
    private String socialSecurityNumber;
    private String bankAccountNumber;
    @Lob
    private String  photo;
    private double leaveBalanceRest;
    private double leaveBalance;
    private Long productivity;
    private String nationalIdentity;
    private LocalDate recruitmentDate;
    private Boolean isEmployee;


    @JsonIgnore
    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)
    private List<Contract> contractsList;

    //relation  oneTomany avec availability
    @JsonIgnore
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Availability> availabilityList;


//relation manytomany avec equipements
@ManyToMany(cascade = CascadeType.ALL)
@JoinTable(
        name = "AssEquipmentEmployee",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "equipment_id")
)
private List<Equipment> equipmentList;
}





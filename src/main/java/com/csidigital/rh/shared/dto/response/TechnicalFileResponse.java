package com.csidigital.rh.shared.dto.response;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.shared.enumeration.Nationality;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.List;

@Data
public class TechnicalFileResponse {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;
    private  String reference;
    private String description;
    private String objective;
    private String driverLicense;
    private List<Education> educations;
    private List<Experience> experiences;
    private List<Skills> skills;
    private List<Language> languages;
    private List<Certification> certifications;
    private Long employeeId;
    private Long experienceAmount;



}
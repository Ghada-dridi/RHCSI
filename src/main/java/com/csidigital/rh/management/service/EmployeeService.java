package com.csidigital.rh.management.service;

import com.csidigital.rh.dao.entity.*;
import com.csidigital.rh.shared.dto.request.EmployeeRequest;
import com.csidigital.rh.shared.dto.response.EmployeeResponse;

import com.csidigital.rh.shared.dto.request.EmployeeRequest;
import com.csidigital.rh.shared.dto.response.*;


import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest request);
    List<EmployeeResponse> getAllEmployees();
    EmployeeResponse getEmployeeById(Long id);

    EmployeeResponse updateEmployee(EmployeeRequest request, Long id);
    boolean hasAdministrativeData(Long employeeId);
    void deleteEmployee(Long id);
    AdministrativeDataResponse getEmployeeAdministartiveData(Long id);
   // void deleteEmployee(Long id);

    TechnicalFileResponse getEmployeeTechnicalFile(Long id);

    List<EducationResponse> getEmployeeEducation(Long id);
    List<ExperienceResponse> getEmployeeExperience(Long id);
    List<CertificationResponse> getEmployeeCertification(Long id);
    List<LanguageResponse> getEmployeeLanguage(Long id);
    List<SkillsResponse> getEmployeeSkills(Long id);


    String employeeSerialNumberGenerator ();

    List<Employee> findByEmployeeStatus();

    List<Employee> getAllCandidates ();
    List<Employee> getAllResourcesBackOffice ();

    List<Employee> getAllResourcesInterne ();

    List<Employee> getAllResourcesExterne();
    List<Employee> getAllInternes();

    List<AssOfferCandidateResponse> getOfferCandidates(Long id);
    void updateStatusToInProcessById (Long id);
    void updateStatusToInProgressById (Long id);
    void updateStatusToTopProfilesById (Long id);
    void updateStatusToPreQualifiedById (Long id);
    void updateStatusToConvertedToResourceById (Long id);
    void  updateStatusToDoNotContactById(Long id);
    void updateStatusToArchiveById (Long id);

    List<Employee>  getConvertedCandidates();
    List<Employee> getNotConvertedCandidates();
    public List<Contract> getContractsEmployee(Long id);

    public List<Availability> getAvailabilityEmployee(Long id);
}


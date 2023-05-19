package com.csidigital.rh.management.controller;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.management.service.impl.EmployeeImpl;
import com.csidigital.rh.shared.dto.request.EmployeeRequest;
import com.csidigital.rh.shared.dto.response.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/rh/employee")
public class EmployeeController {
    @Autowired
    private EmployeeImpl employeeService;
    @Autowired
    public EmployeeController(EmployeeImpl employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/getEmployees")
    public List<EmployeeResponse> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/get/{id}")
    public EmployeeResponse getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/get/{id}/technicalFile")
    public TechnicalFileResponse getEmployeeTechnicalFile(@PathVariable Long id) {
        return employeeService.getEmployeeTechnicalFile(id);
    }

    @GetMapping("get/{id}/education")
    public List<EducationResponse> getEmployeeEducation(@PathVariable Long id) {
        return employeeService.getEmployeeEducation(id);
    }

    @GetMapping("get/{id}/experience")
    public List<ExperienceResponse> getEmployeeExperience(@PathVariable Long id) {
        return employeeService.getEmployeeExperience(id);
    }

    @GetMapping("get/{id}/certificaton")
    public List<CertificationResponse> getEmployeeCertification(@PathVariable Long id) {
        return employeeService.getEmployeeCertification(id);
    }

    @GetMapping("get/{id}/language")
    public List<LanguageResponse> getEmployeeLanguage(@PathVariable Long id) {
        return employeeService.getEmployeeLanguage(id);
    }

    @GetMapping("get/{id}/skills")
    public List<SkillsResponse> getEmployeeSkills(@PathVariable Long id) {
        return employeeService.getEmployeeSkills(id);
    }

    @GetMapping("get/{id}/candidature")
    public List<AssOfferCandidateResponse> getOfferCandidates(@PathVariable Long id) {
        return employeeService.getOfferCandidates(id);
    }

    @PostMapping("/add")
    public EmployeeResponse createEmployee(@Valid @RequestBody EmployeeRequest employeeRequest){
        return employeeService.createEmployee(employeeRequest);
    }

    @PutMapping("/update/{id}")
    public EmployeeResponse updateEmployee(@Valid @RequestBody EmployeeRequest employeeRequest,
                                         @PathVariable Long id){
        return employeeService.updateEmployee(employeeRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
@GetMapping("/testV1")
    public List<Employee> getEmployee(){
        return employeeService.findByEmployeeStatus();
}

@GetMapping("/getAllCandidates")
    public List<Employee> getAllCandidates(){
        return employeeService.getAllCandidates();
}
    @GetMapping("/getAllResourcesBackOffice")
    public List<Employee> getAllResourcesBackOffice(){
        return employeeService.getAllResourcesBackOffice();
    }
    @GetMapping("/getAllResourcesInterne")
    public List<Employee> getAllResourcesInterne(){
        return employeeService.getAllResourcesInterne();
    }
    @GetMapping("/getAllResourcesExterne")
    public List<Employee> getAllResourcesExterne(){
        return employeeService.getAllResourcesExterne();
    }


    @PutMapping("/updateToInProcessById/{id}")
    void updateStatusToInProcessById(@PathVariable Long id) {
        employeeService.updateStatusToInProcessById(id);
    }

    @PutMapping("/updateToInProgressById/{id}")
    void updateStatusToInProgressById(@PathVariable Long id) {
        employeeService.updateStatusToInProgressById(id);
    }

    @PutMapping("/updateToTopProfilesById/{id}")
    void updateStatusToTopProfilesById(@PathVariable Long id) {
        employeeService.updateStatusToTopProfilesById(id);
    }

    @PutMapping("/updateToPreQualifiedById/{id}")
    void updateStatusToPreQualifiedById(@PathVariable Long id) {
        employeeService.updateStatusToPreQualifiedById(id);
    }

    @PutMapping("/updateToConvertedToResourceById/{id}")
    void updateStatusToConvertedToResourceById(@PathVariable Long id) {
        employeeService.updateStatusToConvertedToResourceById(id);
    }

    @PutMapping("/updateToDoNotContactById/{id}")
    void updateStatusToDoNotContactById(@PathVariable Long id) {
        employeeService.updateStatusToDoNotContactById(id);
    }

    @PutMapping("/updateToArchiveById/{id}")
    void updateStatusToArchiveById(@PathVariable Long id) {
        employeeService.updateStatusToArchiveById(id);
    }
}


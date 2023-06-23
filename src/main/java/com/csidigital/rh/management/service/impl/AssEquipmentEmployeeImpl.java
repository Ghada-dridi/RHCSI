package com.csidigital.rh.management.service.impl;


import com.csidigital.rh.dao.entity.Article;
import com.csidigital.rh.dao.entity.AssEquipmentEmployee;
import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.Equipment;
import com.csidigital.rh.dao.repository.AssEquipmentEmployeeRepository;
import com.csidigital.rh.dao.repository.AssOfferCandidateRepository;
import com.csidigital.rh.dao.repository.EmployeeRepository;
import com.csidigital.rh.dao.repository.EquipmentRepository;
import com.csidigital.rh.management.service.AssEquipmentEmployeeService;
import com.csidigital.rh.shared.dto.request.AssEquipmentEmployeeRequest;
import com.csidigital.rh.shared.dto.response.ArticleResponse;
import com.csidigital.rh.shared.dto.response.AssEquipmentEmployeeResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class AssEquipmentEmployeeImpl implements AssEquipmentEmployeeService {
    @Autowired
    private AssEquipmentEmployeeRepository assEquipmentEmployeeRepository ;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;

    @Override
    public AssEquipmentEmployeeResponse createAssEquipmentEmployee(AssEquipmentEmployeeRequest request) {
        AssEquipmentEmployee assEquipmentEmployee = modelMapper.map(request, AssEquipmentEmployee.class);
        Employee employee = employeeRepository.findById(request.getEmployeeNum()).orElseThrow();
        Equipment equipment = equipmentRepository.findById(request.getEquipmentNum()).orElseThrow();
        assEquipmentEmployee.setEmployee(employee);
        assEquipmentEmployee.setEquipment(equipment);
        AssEquipmentEmployee AssEquipmentEmployeeSaved = assEquipmentEmployeeRepository.save(assEquipmentEmployee);
        return modelMapper.map(AssEquipmentEmployeeSaved, AssEquipmentEmployeeResponse.class);
    }

    @Override
    public List<AssEquipmentEmployeeResponse> getAllAssEquipmentEmployee() {
        List<AssEquipmentEmployee> assEquipmentEmployees = assEquipmentEmployeeRepository.findAll();
        List<AssEquipmentEmployeeResponse> assEquipmentEmployeeList = new ArrayList<>();

        for (AssEquipmentEmployee assEquipmentEmployee : assEquipmentEmployees) {
            AssEquipmentEmployeeResponse response = modelMapper.map(assEquipmentEmployee, AssEquipmentEmployeeResponse.class);
            assEquipmentEmployeeList.add(response);
        }

        return assEquipmentEmployeeList;
    }

    @Override
    public AssEquipmentEmployeeResponse getAssEquipmentEmployeeById(Long id) {
        AssEquipmentEmployee assEquipmentEmployee = assEquipmentEmployeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("assEquipmentEmployee Article with id " +id+ " not found"));
        AssEquipmentEmployeeResponse assEquipmentEmployeeResponse = modelMapper.map(assEquipmentEmployee, AssEquipmentEmployeeResponse.class);
        return assEquipmentEmployeeResponse;
    }

    @Override
    public AssEquipmentEmployeeResponse updateAssEquipmentEmployee(AssEquipmentEmployeeRequest request, Long id) {
        AssEquipmentEmployee existingAssEquipmentEmployee = assEquipmentEmployeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("assEquipmentEmployee with id: " + id + " not found"));
        modelMapper.map(request, existingAssEquipmentEmployee);
        AssEquipmentEmployee savedAssEquipmentEmployee = assEquipmentEmployeeRepository.save(existingAssEquipmentEmployee);
        return modelMapper.map(savedAssEquipmentEmployee, AssEquipmentEmployeeResponse.class);
    }

    @Override
    public void deleteAssEquipmentEmployee(Long id) {
        assEquipmentEmployeeRepository.deleteById(id);

    }
}

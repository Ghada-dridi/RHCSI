package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.EmployeeReferenceSequence;
import com.csidigital.rh.dao.entity.ExternalResource;
import com.csidigital.rh.dao.repository.EmployeeReferenceSequenceRepository;
import com.csidigital.rh.dao.repository.ExternalResourceRepository;
import com.csidigital.rh.management.service.ExternalResourceService;
import com.csidigital.rh.shared.dto.request.ExternalResourceRequest;
import com.csidigital.rh.shared.dto.response.ExternalResourceResponse;

import com.csidigital.rh.shared.enumeration.ResourceType;

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

public class ExternalResourceImpl implements ExternalResourceService {
    @Autowired
    private ExternalResourceRepository externalResourceRepository ;
    @Autowired
    private EmployeeReferenceSequenceRepository employeeReferenceSequenceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ExternalResourceResponse createExternalResource(ExternalResourceRequest request) {
        EmployeeReferenceSequence sequence = employeeReferenceSequenceRepository.findById(1L)
                .orElse(null) ;
        if (sequence == null) {
            sequence = new EmployeeReferenceSequence();
            sequence = employeeReferenceSequenceRepository.save(sequence);
        }
        ExternalResource externalResource = modelMapper.map(request, ExternalResource.class);
        String employeeReference = String.format("EX_%04d", sequence.getNextValue());
        externalResource.setSerialNumber(employeeReference);
        externalResource.setResourceType(ResourceType.EXTERNAL_RESOURCE);
        sequence.incrementNextValue();
        employeeReferenceSequenceRepository.save(sequence);
        ExternalResource externalResourceSaved = externalResourceRepository.save(externalResource);
        return modelMapper.map(externalResourceSaved, ExternalResourceResponse.class);
    }

    @Override
    public List<ExternalResourceResponse> getAllExternalResource() {
        List<ExternalResource> externalResource = externalResourceRepository.findAll();
        List<ExternalResourceResponse> externalResourceList = new ArrayList<>();


        for (ExternalResource ExternalResources: externalResource) {
            ExternalResourceResponse response = modelMapper.map(ExternalResources, ExternalResourceResponse.class);
            externalResourceList.add(response);
        }

        return externalResourceList;
    }

    @Override
    public ExternalResourceResponse getExternalResourceById(Long id) {
        ExternalResource externalResource =externalResourceRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExternalResource with id " +id+ " not found"));
        ExternalResourceResponse externalResourceResponse = modelMapper.map(externalResource, ExternalResourceResponse.class);
        return externalResourceResponse;
    }

    @Override
    public ExternalResourceResponse updateExternalResource(ExternalResourceRequest request, Long id) {
        ExternalResource existingExternalResource = externalResourceRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("ExternalResource with id: " + id + " not found"));
        modelMapper.map(request, existingExternalResource);
        ExternalResource savedExternalResource = externalResourceRepository.save(existingExternalResource);
        return modelMapper.map(savedExternalResource, ExternalResourceResponse.class);
    }

    @Override
    public void deleteExternalResource(Long id) {
        externalResourceRepository.deleteById(id);
    }

}

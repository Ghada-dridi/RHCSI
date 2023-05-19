package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.EmployeeReferenceSequence;
import com.csidigital.rh.dao.entity.RecommendationReward;
import com.csidigital.rh.dao.entity.Resource;
import com.csidigital.rh.dao.repository.EmployeeReferenceSequenceRepository;
import com.csidigital.rh.dao.repository.RecommendationRewardRepository;
import com.csidigital.rh.dao.repository.ResourceRepository;
import com.csidigital.rh.management.service.ResourceService;
import com.csidigital.rh.shared.dto.request.RecommendationRewardRequest;
import com.csidigital.rh.shared.dto.request.ResourceRequest;
import com.csidigital.rh.shared.dto.response.RecommendationRewardResponse;
import com.csidigital.rh.shared.dto.response.ResourceResponse;

import com.csidigital.rh.shared.enumeration.ResourceType;

import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
@Transactional
public class ResourceImpl implements ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;
    @Autowired
    private EmployeeReferenceSequenceRepository employeeReferenceSequenceRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResourceResponse createResource(ResourceRequest request) {
        EmployeeReferenceSequence sequence = employeeReferenceSequenceRepository.findById(1L)
                .orElse(null) ;
        if (sequence == null) {
            sequence = new EmployeeReferenceSequence();
            sequence = employeeReferenceSequenceRepository.save(sequence);
        }
        Resource resource = modelMapper.map(request, Resource.class);
        String employeeReference = String.format("RI_%04d", sequence.getNextValue());
       resource.setSerialNumber(employeeReference);
        resource.setResourceType(ResourceType.INTERNAL_RESOURCE);
        sequence.incrementNextValue();
        employeeReferenceSequenceRepository.save(sequence);
        Resource resourceSaved = resourceRepository.save(resource);
        return modelMapper.map(resourceSaved, ResourceResponse.class);
    }

    @Override
    public List<ResourceResponse> getAllResources() {
        List<Resource> resources = resourceRepository.findAll();
        List<ResourceResponse> resourceResponseList= new ArrayList<>();

        for (Resource resource : resources) {
           ResourceResponse response = modelMapper.map(resource ,ResourceResponse.class);
            resourceResponseList.add(response);
        }

        return resourceResponseList;
    }

    @Override
    public ResourceResponse getResourceById(Long id) {
        Resource resource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id " + id + " not found"));
        ResourceResponse resourceResponse = modelMapper.map(resource, ResourceResponse.class);
        return resourceResponse;
    }

    @Override
    public ResourceResponse updateResource(ResourceRequest request, Long id) {
        Resource existingResource = resourceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Resource with id: " + id + " not found"));
        modelMapper.map(request, existingResource);
        Resource savedResource = resourceRepository.save(existingResource);
        return modelMapper.map(savedResource, ResourceResponse.class);
    }

    @Override
    public void deleteResource(Long id) {resourceRepository.deleteById(id);
    }
}

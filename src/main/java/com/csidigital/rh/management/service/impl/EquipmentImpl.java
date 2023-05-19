package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Availability;
import com.csidigital.rh.dao.entity.Equipment;
import com.csidigital.rh.dao.repository.EducationRepository;
import com.csidigital.rh.dao.repository.EquipmentRepository;
import com.csidigital.rh.management.service.EquipmentService;
import com.csidigital.rh.shared.dto.request.EquipmentRequest;
import com.csidigital.rh.shared.dto.response.AvailabilityResponse;
import com.csidigital.rh.shared.dto.response.EquipmentResponse;
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
public class EquipmentImpl implements EquipmentService {
    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Override
    public EquipmentResponse createEquipment(EquipmentRequest request) {
        Equipment equipment = modelMapper.map(request, Equipment.class);
       Equipment EquipmentSaved = equipmentRepository.save(equipment);
        return modelMapper.map(EquipmentSaved, EquipmentResponse.class);
    }

    @Override
    public List<EquipmentResponse> getAllEquipments() {
        List<Equipment> equipment = equipmentRepository.findAll();
        List<EquipmentResponse> equipmentList = new ArrayList<>();


        for (Equipment equipments: equipment) {
            EquipmentResponse response = modelMapper.map(equipments, EquipmentResponse.class);
            equipmentList.add(response);
        }

        return equipmentList;
    }

    @Override
    public EquipmentResponse getEquipmentById(Long id) {
        Equipment equipment =equipmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Availability with id " +id+ " not found"));
        EquipmentResponse equipmentResponse = modelMapper.map(equipment, EquipmentResponse.class);
        return equipmentResponse;
    }

    @Override
    public EquipmentResponse updateEquipment(EquipmentRequest request, Long id) {
        Equipment existingEquipment = equipmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Availability with id: " + id + " not found"));
        modelMapper.map(request, existingEquipment);
        Equipment savedEquipment = equipmentRepository.save(existingEquipment);
        return modelMapper.map( savedEquipment, EquipmentResponse.class);
    }

    @Override
    public void deleteEquipment(Long id) {
        equipmentRepository.deleteById(id);

    }
}

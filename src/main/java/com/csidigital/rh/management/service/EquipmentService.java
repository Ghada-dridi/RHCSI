package com.csidigital.rh.management.service;

import com.csidigital.rh.shared.dto.request.EquipmentRequest;
import com.csidigital.rh.shared.dto.request.EvaluationRequest;
import com.csidigital.rh.shared.dto.response.EquipmentResponse;
import com.csidigital.rh.shared.dto.response.EvaluationResponse;

import java.util.List;

public interface EquipmentService {
    EquipmentResponse createEquipment(EquipmentRequest request);
    List<EquipmentResponse> getAllEquipments();
    EquipmentResponse getEquipmentById(Long id);

    EquipmentResponse updateEquipment(EquipmentRequest request, Long id);

    void deleteEquipment(Long id);

}

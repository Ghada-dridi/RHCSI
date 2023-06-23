package com.csidigital.rh.management.service;

import com.csidigital.rh.dao.entity.Equipment;
import com.csidigital.rh.shared.dto.request.EquipmentRequest;
import com.csidigital.rh.shared.dto.request.EvaluationRequest;
import com.csidigital.rh.shared.dto.response.EquipmentResponse;
import com.csidigital.rh.shared.dto.response.EvaluationResponse;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EquipmentService {
    EquipmentResponse createEquipment(EquipmentRequest request);
    List<EquipmentResponse> getAllEquipments();
    EquipmentResponse getEquipmentById(Long id);

    EquipmentResponse updateEquipment(EquipmentRequest request, Long id);

    void deleteEquipment(Long id);


    void updateStatusToAvailableById(Long id);
    void updateStatusToUnavailableById(Long id);
    void updateMotifById(Long id, String motifUnavailability, LocalDate disponibilityDate);
    void updateAffectedById(Long id);
    void updateUnaffectedById(Long id);




























    List<Equipment> getAffectableEquipments();
    Long countEquipment();


}

package com.csidigital.rh.management.controller;


import com.csidigital.rh.dao.entity.Equipment;
import com.csidigital.rh.management.service.impl.EquipmentImpl;
import com.csidigital.rh.shared.dto.request.AvailabilityRequest;
import com.csidigital.rh.shared.dto.request.EquipmentRequest;
import com.csidigital.rh.shared.dto.response.AvailabilityResponse;
import com.csidigital.rh.shared.dto.response.EquipmentResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rh/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentImpl equipmentImpl;
    @GetMapping("getAll")
    public List<EquipmentResponse> getAllEquipment() {

        return equipmentImpl.getAllEquipments();
    }

    @GetMapping("/getById/{id}")
    public EquipmentResponse getEquipmentById(@PathVariable Long id){
        return equipmentImpl.getEquipmentById(id);
    }

    @PostMapping("/add")
    public EquipmentResponse createEquipment(@Valid @RequestBody EquipmentRequest equipmentRequest){
        return equipmentImpl.createEquipment(equipmentRequest);
    }

    @PutMapping("/update/{id}")
    public EquipmentResponse updateEquipment(@Valid @RequestBody EquipmentRequest equipmentRequest,
                                                   @PathVariable Long id){
        return equipmentImpl.updateEquipment(equipmentRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEquipement(@PathVariable Long id){

        equipmentImpl.deleteEquipment(id);}

    @PutMapping("/updateToAvailableById/{id}")
    void  updateStatusToAvailableById(@PathVariable Long id){

        equipmentImpl.updateStatusToAvailableById(id);
    }

    @PutMapping("/updateToUnavailableById/{id}")
    void  updateStatusToUnavailableById(@PathVariable Long id){

        equipmentImpl.updateStatusToUnavailableById(id);
    }

    @PutMapping("/updateAffectedById/{id}")
    void  updateAffectedById(@PathVariable Long id){

        equipmentImpl.updateAffectedById(id);
    }
    @PutMapping("/updateUnaffectedById/{id}")
    void  updateUnaffectedById(@PathVariable Long id){

        equipmentImpl.updateUnaffectedById(id);
    }
    @PutMapping("/updateMotifById/{id}")
    void updateMotifById(@PathVariable Long id, @RequestBody EquipmentRequest request) {
        String motifUnavailability = request.getMotifUnavailability();
        LocalDate disponibilityDate = request.getDisponibilityDate();
        equipmentImpl.updateMotifById(id, motifUnavailability,disponibilityDate);
    }
    @GetMapping("/getAllAffectable")
    public List<Equipment> getAllAffectables() {

        return equipmentImpl.getAffectableEquipments();
    }

    @GetMapping("/getNumber")
    public Long countEquipment() {
        return equipmentImpl.countEquipment();
    }

/*

    @PutMapping("/employees/{employeeId}/equipment/{equipmentId}")
    public ResponseEntity<String> assignEquipmentToEmployee(
            @PathVariable Long employeeId,
            @PathVariable Long equipmentId) {
        equipmentImpl.assignEquipmentToEmployee(employeeId, equipmentId);
        return ResponseEntity.status(HttpStatus.OK).body("Equipment assigned successfully");
    }*/
}

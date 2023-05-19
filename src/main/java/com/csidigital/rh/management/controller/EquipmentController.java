package com.csidigital.rh.management.controller;


import com.csidigital.rh.management.service.impl.EquipmentImpl;
import com.csidigital.rh.shared.dto.request.AvailabilityRequest;
import com.csidigital.rh.shared.dto.request.EquipmentRequest;
import com.csidigital.rh.shared.dto.response.AvailabilityResponse;
import com.csidigital.rh.shared.dto.response.EquipmentResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}

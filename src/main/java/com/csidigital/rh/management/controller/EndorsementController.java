package com.csidigital.rh.management.controller;


import com.csidigital.rh.management.service.impl.EndorsementImpl;
import com.csidigital.rh.shared.dto.request.ArticleRequest;
import com.csidigital.rh.shared.dto.request.EndorsementRequest;
import com.csidigital.rh.shared.dto.response.ArticleResponse;
import com.csidigital.rh.shared.dto.response.EndorsementResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh/endorsement")
public class EndorsementController {

    @Autowired
    private EndorsementImpl endorsementImpl;

    @GetMapping("/getEndorsements")
    public List<EndorsementResponse> getAllEndorsements() {

        return endorsementImpl.getAllEndorsements();
    }

    @GetMapping("/get/{id}")
    public EndorsementResponse getEndorsementById(@PathVariable Long id){

        return endorsementImpl.getEndorsementById(id);
    }

    @PostMapping("/add")
    public EndorsementResponse createEndorsement(@Valid @RequestBody EndorsementRequest endorsementRequest){
        return endorsementImpl.createEndorsement(endorsementRequest);
    }

    @PutMapping("/update/{id}")
    public EndorsementResponse updateEndorsement(@Valid @RequestBody EndorsementRequest endorsementRequest,
                                         @PathVariable Long id){
        return endorsementImpl.updateEndorsement(endorsementRequest, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEndorsement(@PathVariable Long id){
        endorsementImpl.deleteEndorsement(id);
    }
}

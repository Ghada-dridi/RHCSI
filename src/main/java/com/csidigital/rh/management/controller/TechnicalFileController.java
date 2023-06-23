package com.csidigital.rh.management.controller;

import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.management.service.impl.SkillsImpl;
import com.csidigital.rh.management.service.impl.TechnicalFileImpl;
import com.csidigital.rh.shared.dto.request.SkillsRequest;
import com.csidigital.rh.shared.dto.request.TechnicalFileRequest;
import com.csidigital.rh.shared.dto.response.EducationResponse;
import com.csidigital.rh.shared.dto.response.SkillsResponse;
import com.csidigital.rh.shared.dto.response.TechnicalFileResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/rh/technicalFile")
public class TechnicalFileController {
    @Autowired
    private TechnicalFileImpl technicalFile;

    @GetMapping("/getAll")
    public List<TechnicalFileResponse> getAllTechnicalFile(){
        return technicalFile.getAllTechnicalFiles();
    }
    @GetMapping("/get/{id}/education")
    public List<EducationResponse> getTechnicalFileEducation( @PathVariable  Long id){
        return technicalFile.getTechnicalFileEducation(id);
    }
    @GetMapping("/getTechnicalFile/{id}")
    public TechnicalFileResponse getTechnicalFileById(@PathVariable Long id){
        return technicalFile.getTechnicalFileById(id);
    }

    @PostMapping("/addTechnicalFile")
    public TechnicalFileResponse createTechnicalFile(@Valid @RequestBody TechnicalFileRequest technicalFileRequest){
        return technicalFile.createTechnicalFile(technicalFileRequest);
    }

    @PutMapping("/updateTechnicalFile/{id}")
    public TechnicalFileResponse updateSkills(@Valid @RequestBody TechnicalFileRequest technicalFileRequest,
                                              @PathVariable Long id){
        return technicalFile.updateTechnicalFile(technicalFileRequest, id);
    }

    @DeleteMapping("/deleteTechnicalFile/{id}")
    public void deleteTechnicalFile(@PathVariable Long id){
        technicalFile.deleteTechnicalFile(id);
    }
    @GetMapping("/{id}/employee")
    public TechnicalFileResponse getByEmployeeId(@PathVariable Long id){
        return technicalFile.getTechnicalFileByEmployeeId(id);
    }
}
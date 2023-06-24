package com.csidigital.rh.management.service.impl;

import com.csidigital.rh.dao.entity.Article;
import com.csidigital.rh.dao.entity.Contract;
import com.csidigital.rh.dao.entity.Endorsement;
import com.csidigital.rh.dao.entity.TechnicalFile;
import com.csidigital.rh.dao.repository.ContractRepository;
import com.csidigital.rh.dao.repository.EndorsementRepository;
import com.csidigital.rh.management.service.EndorsementService;
import com.csidigital.rh.shared.dto.request.EndorsementRequest;
import com.csidigital.rh.shared.dto.response.ArticleResponse;
import com.csidigital.rh.shared.dto.response.EndorsementResponse;
import com.csidigital.rh.shared.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
@AllArgsConstructor
public class EndorsementImpl implements EndorsementService {

    @Autowired
    private ModelMapper modelMapper ;
    @Autowired
    private EndorsementRepository endorsementRepository;
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public EndorsementResponse createEndorsement(EndorsementRequest request) {
        Endorsement endorsement = modelMapper.map(request, Endorsement.class);
        Contract contract = contractRepository.findById(request.getContractNum()).orElseThrow();

        //Définition de la contractDate à la date actuelle
        LocalDate currentDate = LocalDate.now();
        endorsement.setEndorsementDate(currentDate);

         endorsement.setContract(contract);
        Endorsement EndorsementSaved = endorsementRepository.save(endorsement);
        // Génération de la référence
        String reference = EndorsementSaved.getContract().getReference();
        String contractId = String.format("%03d", EndorsementSaved.getContract().getId());
        int endorsementCount = EndorsementSaved.getContract().getEndorsementList().size() + 1;
        String endorsementSuffix = String.format("%03d", endorsementCount);
        if (endorsementCount == 1) {
            endorsementSuffix = "001";
        }
        String finalReference = reference + "_" + endorsementSuffix;
        EndorsementSaved.setReference(finalReference);
        return modelMapper.map( EndorsementSaved , EndorsementResponse.class);
    }
    /*@Override
    public EndorsementResponse createEndorsement(EndorsementRequest request) {
        Endorsement endorsement = modelMapper.map(request, Endorsement.class);
        Endorsement EndorsementSaved = endorsementRepository.save(endorsement);
        return modelMapper.map( EndorsementSaved , EndorsementResponse.class);
    }*/

    @Override
    public List<EndorsementResponse> getAllEndorsements() {
        List<Endorsement> endorsements = endorsementRepository.findAll();
        List<EndorsementResponse> endorsementList = new ArrayList<>();

        for (Endorsement endorsement : endorsements) {
            EndorsementResponse response = modelMapper.map(endorsement, EndorsementResponse.class);
            endorsementList.add(response);
        }

        return endorsementList;
    }

    @Override
    public EndorsementResponse getEndorsementById(Long id) {
        Endorsement endorsement = endorsementRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Endorsement with id " +id+ " not found"));
        EndorsementResponse endorsementResponse = modelMapper.map(endorsement, EndorsementResponse.class);
        return endorsementResponse;
    }

    @Override
    public EndorsementResponse updateEndorsement(EndorsementRequest request, Long id) {
        Endorsement existingEndorsement = endorsementRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Article with id: " + id + " not found"));
        modelMapper.map(request, existingEndorsement);
        Endorsement savedEndorsement = endorsementRepository.save(existingEndorsement);
        return modelMapper.map(savedEndorsement, EndorsementResponse.class);
    }

    @Override
    public void deleteEndorsement(Long id) {
        endorsementRepository.deleteById(id);

    }
}

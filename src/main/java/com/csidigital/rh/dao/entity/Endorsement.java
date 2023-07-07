package com.csidigital.rh.dao.entity;


import com.csidigital.rh.shared.enumeration.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endorsement {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="reference")
    private String reference;
    @Column(name = "title")
    private String title;
    @Column(name = "endorsementDate")
    private LocalDate endorsementDate;
    @Column(name = "object")
    private String object;
    @Column(name = "note")
    private String note;

    @Column(name ="validityDate")
    private LocalDate validityDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_contract")
    private Contract contract;

}

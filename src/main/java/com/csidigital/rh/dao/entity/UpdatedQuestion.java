package com.csidigital.rh.dao.entity;


import com.csidigital.rh.shared.enumeration.InterviewType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdatedQuestion {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private Integer mark;
    private String comment;
    private String questionText;


    @Enumerated(EnumType.STRING)
    private InterviewType interviewType;

    @ManyToOne()
    @JoinColumn(name = "interviewId")
    private Interview interview ;
}
package com.csidigital.rh.dao.entity;
import com.csidigital.rh.shared.enumeration.ExperienceLevel;
import com.csidigital.rh.shared.enumeration.QuestionnaireType;
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

public class QuestionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String name ;

    @JsonIgnore
    @OneToMany(mappedBy = "questionCategory" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions;

     @ManyToOne()
     @JsonIgnore
     @JoinColumn(name = "categoryId")
     private QuestionType questionType;


    @Enumerated(EnumType.STRING)
    private ExperienceLevel level ;

    @Enumerated(EnumType.STRING)
    private QuestionnaireType questionnaireType ;
}

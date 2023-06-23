package com.csidigital.rh.dao.entity;

import com.csidigital.rh.shared.enumeration.LanguageLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Enumerated(EnumType.STRING)
    private com.csidigital.rh.shared.enumeration.Language language;
    private String additionalInformation;
    @Enumerated(EnumType.STRING)
    private LanguageLevel languageLevel;
    @ManyToOne( )
    @JsonIgnore
    @JoinColumn(name = "technicalFileId")
    private TechnicalFile technicalFile;
}

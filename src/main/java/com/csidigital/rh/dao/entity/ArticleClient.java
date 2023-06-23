package com.csidigital.rh.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleClient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "articleNumber")
    private Integer articleNumber;
    @Column(name = "articleTitle")
    private String articleTitle;
    @Column(name = "description" , length = 100000)
    private String description;

    @JsonIgnore
    @ManyToOne
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "id_contract")
    private ContractClient contractClient;

}

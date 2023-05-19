package com.csidigital.rh.dao.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Resource extends Employee{





    @OneToMany(mappedBy = "resource")
    private List<Contract> contractsList;




}

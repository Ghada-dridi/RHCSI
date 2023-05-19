package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
}

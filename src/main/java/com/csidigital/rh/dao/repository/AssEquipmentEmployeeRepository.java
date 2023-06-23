package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.ArticleUpdated;
import com.csidigital.rh.dao.entity.AssEquipmentEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssEquipmentEmployeeRepository extends JpaRepository<AssEquipmentEmployee,Long> {

}

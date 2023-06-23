package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Endorsement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EndorsementRepository extends JpaRepository<Endorsement,Long> {
}

package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.dao.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long> {

    @Modifying
    @Query(value = " UPDATE equipment SET status = 'AVAILABLE' WHERE id =:id", nativeQuery = true)
    void updateStatusToAvailableById(@Param("id") Long id);


    @Modifying
    @Query(value = " UPDATE equipment SET status = 'UNAVAILABLE' WHERE id =:id", nativeQuery = true)
    void updateStatusToUnavailableById(@Param("id") Long id);


    @Modifying
    @Query(value = "UPDATE equipment SET motif_unavailability = :motifUnavailability, disponibilityDate = :disponibilityDate WHERE id = :id", nativeQuery = true)
    void updateMotifById(@Param("id") Long id, @Param("motifUnavailability") String motifUnavailability, @Param("disponibilityDate")LocalDate disponibilityDate);

    @Modifying
    @Query(value = "UPDATE equipment SET affectation = 'AFFECTED', status = 'UNAVAILABLE', motif_unavailability = 'Affecté à un employé' WHERE id = :id", nativeQuery = true)
    void updateAffectedById(@Param("id") Long id);


    @Modifying
    @Query(value = " UPDATE equipment SET affectation = 'UNAFFECTED' WHERE id =:id", nativeQuery = true)
    void updateUnaffectedById(@Param("id") Long id);

    @Query(value ="SELECT * FROM equipment WHERE affectable IS TRUE ORDER BY Id DESC;", nativeQuery = true)
    List<Equipment> getAffectableEquipments();



    @Query("SELECT COUNT(e) FROM Equipment e")
    Long countEquipment();
}

package com.csidigital.rh.dao.repository;

import com.csidigital.rh.dao.entity.Employee;
import com.csidigital.rh.shared.enumeration.EmployeeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value ="SELECT serial_number FROM employee WHERE serial_number IS NOT NULL  ORDER BY Id DESC LIMIT 1;",nativeQuery = true)
    String resourceLastCode();


    //Filtrer les candidats
    @Query(value ="SELECT * FROM employee WHERE dtype= 'Employee'", nativeQuery = true)
    List<Employee> getAllCandidates ();

    //Filtrer les Ressources BackOffice
    @Query(value ="SELECT * FROM employee WHERE dtype= 'BackOffice'", nativeQuery = true)
    List<Employee> getAllResourcesBackOffice ();

    //Filtrer les Ressources Internes
    @Query(value ="SELECT * FROM employee WHERE dtype= 'Resource'", nativeQuery = true)
    List<Employee> getAllResourcesInterne ();

    //Filtrer les Ressources externes
    @Query(value ="SELECT * FROM employee WHERE dtype= 'ExternalResource'", nativeQuery = true)
    List<Employee> getAllResourcesExterne();


    //filtrer les employés selon leurs status
    List<Employee> findByEmployeeStatus(EmployeeStatus employeeStatus);
    @Modifying
    @Query(value = " UPDATE employee SET employee_status = 'IN_PROCESS' WHERE id =:id", nativeQuery = true)
    void updateStatusToInProcessById(@Param("id") Long id);
    @Modifying
    @Query(value = " UPDATE employee SET employee_status = 'IN_PROGRESS' WHERE id =:id", nativeQuery = true)
    void updateStatusToInProgressById(@Param("id") Long id);
    @Modifying
    @Query(value = " UPDATE employee SET employee_status = 'TOP_PROFILES' WHERE id =:id", nativeQuery = true)
    void updateStatusToTopProfilesById(@Param("id") Long id);
    @Modifying
    @Query(value = " UPDATE employee SET employee_status = 'PRE_QUALIFIED' WHERE id =:id", nativeQuery = true)
    void updateStatusToPreQualifiedById(@Param("id") Long id);
    @Modifying
    @Query(value = " UPDATE employee SET employee_status = 'CONVERTED_TO_RESOURCE' WHERE id =:id", nativeQuery = true)
    void updateStatusToConvertedToResourceById(@Param("id") Long id);
    @Modifying
    @Query(value = " UPDATE employee SET employee_status = 'DO_NOT_CONTACT' WHERE id =:id", nativeQuery = true)
    void updateStatusToDoNotContactById(@Param("id") Long id);

    @Modifying
    @Query(value = " UPDATE employee SET employee_status = 'ARCHIVE' WHERE id =:id", nativeQuery = true)
    void updateStatusToArchiveById(@Param("id") Long id);


}

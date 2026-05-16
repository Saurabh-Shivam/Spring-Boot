package com.saurabh.hospitalManagement.repository;

import com.saurabh.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.saurabh.hospitalManagement.entity.Patient;
import com.saurabh.hospitalManagement.entity.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByBirthDateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContaining(String query);

    @Query("SELECT p FROM Patient  p where p.bloodGroup = ?1")
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query("SELECT p FROM Patient  p where p.birthDate > :birthDate")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

//    @Query("SELECT  p.bloodGroup, COUNT(p) FROM Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();

    @Query("SELECT new com.saurabh.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, COUNT(p)) FROM Patient p group by p.bloodGroup")
//    List<Object[]> countEachBloodGroupType();
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient", nativeQuery = true)
    List<Patient> findAllPatient();

    @Transactional
    @Modifying
    @Query("UPDATE Patient p SET p.name = :name where p.id = :id")
    int updateNameWithId(@Param("name") String name, @Param("id") Long id);

    @Query(value = "select * from patient", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

}

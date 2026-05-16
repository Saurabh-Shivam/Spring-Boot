package com.saurabh.hospitalManagement;

import com.saurabh.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.saurabh.hospitalManagement.entity.Patient;
import com.saurabh.hospitalManagement.entity.type.BloodGroupType;
import com.saurabh.hospitalManagement.repository.PatientRepository;
import com.saurabh.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);

        Patient p1 = new Patient();
        patientRepository.save(p1);
    }

    @Test
    public void testTransactionMethods(){

//        Patient patient = patientService.getPatientById(1L);
//        Patient patient = patientRepository.findByName("Rahul Verma");
////        System.out.println(patient);

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1995, 11, 3), "priya.nair@example.com" );
//        for (Patient patient:patientList){
//            System.out.println(patient);
//        }
//        List<Patient> patientList = patientRepository.findByNameContaining("ma");
//        for (Patient patient:patientList){
//            System.out.println(patient);
//        }
//        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
//        for (Patient patient:patientList){
//            System.out.println(patient);
//        }
//        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1995, 11, 3));
//        for (Patient patient:patientList){
//            System.out.println(patient);
//        }
//        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (Object[] objects: bloodGroupList){
//            System.out.println(objects[0] + " " + objects[1]);
//        }
//        List<Patient> patientList = patientRepository.findAllPatient();
//        for (Patient patient: patientList){
//            System.out.println(patient);
//        }

        // Modifying in JPQL
//        int rowsUpdated = patientRepository.updateNameWithId("Saurabh Shivam", 1L);
//        System.out.println(rowsUpdated);

        // Projection in JPQL
//        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
//        for (BloodGroupCountResponseEntity bloodGroupCountResponseEntity: bloodGroupList){
//            System.out.println(bloodGroupCountResponseEntity);
//        }

        // pagination
//        Page<Patient> patientList = patientRepository.findAllPatient(PageRequest.of(0, 2));
//        for (Patient patient: patientList){
//            System.out.println(patient);
//        }

        // Sorted according to name
        Page<Patient> patientList = patientRepository.findAllPatient(PageRequest.of(0, 2, Sort.by("name")));
        for (Patient patient: patientList){
            System.out.println(patient);
        }



    }
}

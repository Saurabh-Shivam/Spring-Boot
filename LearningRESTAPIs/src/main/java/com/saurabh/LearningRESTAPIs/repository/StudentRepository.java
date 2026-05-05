package com.saurabh.LearningRESTAPIs.repository;

import com.saurabh.LearningRESTAPIs.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // optional
public interface StudentRepository extends JpaRepository<Student, Long> {

}

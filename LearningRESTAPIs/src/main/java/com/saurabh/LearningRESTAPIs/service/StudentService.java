package com.saurabh.LearningRESTAPIs.service;

import com.saurabh.LearningRESTAPIs.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudents();

    StudentDto getStudentById(long id);
}

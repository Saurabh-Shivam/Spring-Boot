package com.saurabh.LearningRESTAPIs.service.impl;

import com.saurabh.LearningRESTAPIs.dto.StudentDto;
import com.saurabh.LearningRESTAPIs.entity.Student;
import com.saurabh.LearningRESTAPIs.repository.StudentRepository;
import com.saurabh.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    public final ModelMapper modelMapper;

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        //        we can either use stream or loop to achieve this but using stream is optimal
        //        with the help of stream we can convert one type of collection to any other type easily using map...filter and other functions
        //        List<StudentDto> studentDtoList = new ArrayList<>();
        //        for (Student student : students) {
        //            StudentDto studentDto = new StudentDto(student.getId(), student.getName(), student.getEmail());
        //            studentDtoList.add(studentDto);
        //        }
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
                .toList();

        return studentDtoList;

        // can achieve this in one line itself
        //        return students
        //                .stream()
        //                .map(student -> new StudentDto(student.getId(), student.getName(), student.getEmail()))
        //                .toList();

        //        or with model mapper
        //        return students
        //                .stream()
        //                .map(student -> modelMapper.map(student, StudentDto.class)
        //                .toList();
    }

    @Override
    public StudentDto getStudentById(long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        // with the help of modelmapper we are able to convert student into studentDto easily
        // StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        // return studentDto;
        return modelMapper.map(student, StudentDto.class);


    }

}

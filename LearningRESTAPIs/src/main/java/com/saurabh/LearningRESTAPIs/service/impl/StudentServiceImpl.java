package com.saurabh.LearningRESTAPIs.service.impl;

import com.saurabh.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.saurabh.LearningRESTAPIs.dto.StudentDto;
import com.saurabh.LearningRESTAPIs.entity.Student;
import com.saurabh.LearningRESTAPIs.repository.StudentRepository;
import com.saurabh.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto) {
        Student newStudent = modelMapper.map(addStudentRequestDto, Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists by id: "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));
        modelMapper.map(addStudentRequestDto, student);
        student = studentRepository.save(student);
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: "+id));

        updates.forEach((field, value) -> {
            switch (field){
                case "name": student.setName((String) value);
                break;
                case "email": student.setEmail((String) value);
                break;
                default: throw new IllegalArgumentException("Field is not supported");
            }
        });

        Student savedstudent = studentRepository.save(student);
        return  modelMapper.map(savedstudent, StudentDto.class);
    }

}

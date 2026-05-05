package com.saurabh.LearningRESTAPIs.controller;

import com.saurabh.LearningRESTAPIs.dto.StudentDto;
import com.saurabh.LearningRESTAPIs.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

//    @GetMapping("/student")
//    public List<StudentDto> getStudent(){
//        return new StudentDto(4L, "Saurabh", "saurabhshivam4@gmail.com");
//    }
//    @GetMapping("/student/{id}")
//    public StudentDto getUserById(@PathVariable int id) {
//        return new StudentDto(4L, "Saurabh", "saurabhshivam4@gmail.com");
//    }

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDto> getStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public StudentDto getUserById(@PathVariable long id) {
        // return "Path variable "+id;
        return studentService.getStudentById(id);
    }

//    @GetMapping("/students/{id}/{name}")
//    public String getUserByName(@PathVariable long id, @PathVariable String name) {
//        return "Path variable "+id + " with name "+name;
//    }
}

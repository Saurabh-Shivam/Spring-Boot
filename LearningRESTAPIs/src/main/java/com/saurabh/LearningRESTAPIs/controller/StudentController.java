package com.saurabh.LearningRESTAPIs.controller;

import com.saurabh.LearningRESTAPIs.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/student")
    public StudentDto getStudent(){
        return new StudentDto(4L, "Saurabh", "saurabhshivam4@gmail.com");
    }

    @GetMapping("/student/{id}")
    public StudentDto getUserById(@PathVariable int id) {
        return new StudentDto(4L, "Saurabh", "saurabhshivam4@gmail.com");
    }

}

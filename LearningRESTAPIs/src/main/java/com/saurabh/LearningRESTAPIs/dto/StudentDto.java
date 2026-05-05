package com.saurabh.LearningRESTAPIs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// instead of adding constructors...getters...setter..etc we can add these annotations as it will automatically
// create all those boilerplate codes when this class file is converted into bytecode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String name;
    private String email;

}

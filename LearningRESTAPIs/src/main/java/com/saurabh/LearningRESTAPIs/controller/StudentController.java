package com.saurabh.LearningRESTAPIs.controller;

import com.saurabh.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.saurabh.LearningRESTAPIs.dto.StudentDto;
import com.saurabh.LearningRESTAPIs.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/students") // to avoid writing same route at every mapping we use this annotation
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

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudents() {
//        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getUserById(@PathVariable long id) {
        // return "Path variable "+id;
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
//    @GetMapping("/students/{id}/{name}")
//    public String getUserByName(@PathVariable long id, @PathVariable String name) {
//        return "Path variable "+id + " with name "+name;
//    }

    @PostMapping
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addStudentRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id, @RequestBody AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.ok(studentService.updateStudent(id, addStudentRequestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updatePartialStudent(@PathVariable Long id, @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id, updates));
    }

}

package com.yadacode.dynamodbpoc.controller;

import com.yadacode.dynamodbpoc.model.student.StudentDTO;
import com.yadacode.dynamodbpoc.service.StudentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public StudentDTO createNewStudent(@RequestBody StudentDTO dto){
        return studentService.createNewStudent(dto);
    }
}

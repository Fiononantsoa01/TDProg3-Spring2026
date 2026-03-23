package com.example.hei.TdProg3Spring.controller;

import com.example.hei.TdProg3Spring.entity.Student;
import com.example.hei.TdProg3Spring.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
public class StudentController {
    // acces vers student service
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }
    // route pour saluer un etudiant
    @GetMapping( "/welcome")
    public ResponseEntity<String> welcome(@RequestParam(value = "name",required = false) String name) {
        if (name == null || name.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Please enter your name");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Welcome " + name);
    }
    @PostMapping(
            value = "/students",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> addStudent(@RequestBody List<Student> newStudents) {
        try {
            List<Student> savedStudents = service.addStudent(newStudents);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedStudents);

        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while adding students");

        }

    }
    @RequestMapping(
            path = "/students",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getStudents(){
        return service.getStudentAsText();
    }

}

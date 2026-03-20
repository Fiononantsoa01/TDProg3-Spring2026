package com.example.hei.TdProg3Spring.controller;

import com.example.hei.TdProg3Spring.entity.Student;
import com.example.hei.TdProg3Spring.service.StudentService;
import org.springframework.http.MediaType;
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
    @RequestMapping(path = "/welcome",method = RequestMethod.GET)
    public String welcome(@RequestParam("name") String name) {
        return "welcome " +name;
    }
    @RequestMapping(
            path = "/students",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public String addStudent(@RequestBody List<Student> newStudents) {
        return service.addStudent(newStudents);

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

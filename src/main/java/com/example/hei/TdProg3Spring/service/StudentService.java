package com.example.hei.TdProg3Spring.service;

import com.example.hei.TdProg3Spring.entity.Student;
import com.example.hei.TdProg3Spring.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class StudentService {
    // acceès vers le stockage local
    private  final StudentRepository repository ;
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    //methode pour ajouter des etudiants
    public String addStudent(List<Student> students) {
        repository.saveAllStudents(students);
        return  repository.findAllStudents().stream()
                .map(std ->std.getName() +" "+ std.getFirstName())
                .collect(Collectors.joining(","));
    }
    // methode pour retourner les etudiant en text plain
    public String getStudentAsText(){
        List<Student> existStudents = repository.findAllStudents();
        if(existStudents.isEmpty()){
            return "the student list is empty until now";
        }
        return existStudents.stream()
                .map(exStd -> exStd.getName() +""+exStd.getFirstName())
                .collect(Collectors.joining(","));
    }

}

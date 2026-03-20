package com.example.hei.TdProg3Spring.repository;

import com.example.hei.TdProg3Spring.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();
    public List<Student> findAllStudents() {
        return students;
    }
    public void saveAllStudents(List<Student> newStudents) {
        students.addAll(newStudents);
    }
}

package com.example.testProject.services;

import com.example.testProject.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudents();
    Optional<Student> findById(int id);
    Optional<Student> findByEmail (String email);
    Student save(Student student);
    void deleteById (int id);
}

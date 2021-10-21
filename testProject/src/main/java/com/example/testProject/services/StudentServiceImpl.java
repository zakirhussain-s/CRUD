package com.example.testProject.services;

import com.example.testProject.models.Student;
import com.example.testProject.repositories.StudentRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRespository studentRespository;

//    @Autowired
//    public StudentServiceImpl(StudentRespository studentRespository){
//        this.studentRespository = studentRespository;
//    }

    @Override
    public List<Student> getAllStudents() {
        return studentRespository.findAll();
    }

    @Override
    public Optional<Student> findById(int id) {
        return studentRespository.findById(id);
    }

    @Override
    public Optional<Student> findByEmail(String email) {
        return studentRespository.findByEmail(email);
    }

    @Override
    public Student save(Student student) {
        return studentRespository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRespository.deleteById(id);
    }
}

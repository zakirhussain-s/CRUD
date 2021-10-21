package com.example.testProject.repositories;

import com.example.testProject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRespository extends JpaRepository<Student,Integer> {

    Optional<Student> findByEmail(String email);
}

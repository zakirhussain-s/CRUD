package com.example.testProject.contollers;

import com.example.testProject.exceptions.StudentNotFoundException;
import com.example.testProject.models.Student;
import com.example.testProject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(value = "/students/{id}")
    public Student getStudentById(@PathVariable("id") int id){
        Student student = studentService.findById(id)
                                            .orElseThrow(() -> new StudentNotFoundException("Student with id "+id+" not found"));
        return student;
    }

    @PostMapping(value = "students")
    public ResponseEntity<String> saveStudent(@RequestBody Student student){
        studentService.save(student);
        return new ResponseEntity<String>("Student Added Successfully", HttpStatus.OK);
    }

    @PutMapping(value = "students/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id,@RequestBody Student student){
        Student newStudent =studentService.findById(id)
                                            .orElseThrow(() -> new StudentNotFoundException("Student with id "+id+" not found"));
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        studentService.save(newStudent);

        return new ResponseEntity<String>("Student updated successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "students/{id}")
    public String deleteStudent(@PathVariable("id") int id){
        Student student = studentService.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with id "+id+" not found"));
        studentService.deleteById(id);
        return "Student with id "+id+" deleted successfully";
    }
}

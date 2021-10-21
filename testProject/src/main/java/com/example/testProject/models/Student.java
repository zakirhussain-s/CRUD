package com.example.testProject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    @NotEmpty(message = "first Name cannot be empty")
    private String firstName;

    @NotEmpty(message = "last Name cannot be empty")
    @Column(name = "last_Name")
    private String lastName;

    @Column(nullable = true, name = "email")
    private String email;

}

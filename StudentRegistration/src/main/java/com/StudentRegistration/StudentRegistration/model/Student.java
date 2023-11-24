package com.StudentRegistration.StudentRegistration.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String regNo;
    @Column(name = "full_name")
    private String fullName;
    private LocalDate dob;

    public Student() {
    }

    public Student(int id, String regNo, String fullName, LocalDate dob) {
        this.id = id;
        this.regNo = regNo;
        this.fullName = fullName;
        this.dob = dob;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
}

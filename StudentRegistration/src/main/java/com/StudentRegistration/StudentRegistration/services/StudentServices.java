package com.StudentRegistration.StudentRegistration.services;

import com.StudentRegistration.StudentRegistration.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServices {

    public boolean saveStudent(Student student);

    public List<Student> studentList();

    public boolean deleteStudent(Student student);

    public Optional<Student> findStudentById(int id);

    public Student findStudentByRegNo(String regNo);


}

package com.StudentRegistration.StudentRegistration.repository;

import com.StudentRegistration.StudentRegistration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer > {

//    Student findById(int id);

//    Student findByRegNo(String regNo);
}

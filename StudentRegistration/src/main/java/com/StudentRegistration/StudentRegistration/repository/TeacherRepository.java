package com.StudentRegistration.StudentRegistration.repository;

import com.StudentRegistration.StudentRegistration.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

//    Teacher findByName(String name);
}

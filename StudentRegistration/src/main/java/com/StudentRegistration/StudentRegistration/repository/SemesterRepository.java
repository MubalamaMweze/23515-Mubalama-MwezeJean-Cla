package com.StudentRegistration.StudentRegistration.repository;

import com.StudentRegistration.StudentRegistration.model.Semester;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer> {

     Semester findByName(String name);
}

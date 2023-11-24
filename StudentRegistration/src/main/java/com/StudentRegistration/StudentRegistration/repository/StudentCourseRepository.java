package com.StudentRegistration.StudentRegistration.repository;

import com.StudentRegistration.StudentRegistration.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
//    List<StudentCourse> findByStudentRegistration_Student_Id(int id);

//    List<StudentCourse> findByCourse_CourseDefinition_IdAndStudentRegistration_Semester_Id(UUID crId, int smId);
}

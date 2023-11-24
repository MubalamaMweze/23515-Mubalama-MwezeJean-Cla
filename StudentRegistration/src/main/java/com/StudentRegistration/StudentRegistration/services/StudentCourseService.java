package com.StudentRegistration.StudentRegistration.services;

import com.StudentRegistration.StudentRegistration.model.StudentCourse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentCourseService {

    public boolean insertStudentCourse(StudentCourse course);

    public List<StudentCourse> studentCourseList();

    public boolean deleteStudentCourse(StudentCourse course);

    public Optional<StudentCourse> courseByStudentId(int id);

    public List<StudentCourse> studentBySemAndCourse(UUID smId, int crId);


}

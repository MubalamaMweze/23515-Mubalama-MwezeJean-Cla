package com.StudentRegistration.StudentRegistration.services;

import com.StudentRegistration.StudentRegistration.model.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseServices {
    boolean saveCourses(Course course);

    List<Course> getALlCourses();

    boolean deleteCourse(Course course);

    Optional<Course> getCourseDefinition(int id);

    Optional<Course> getCourseById(int id);

    List<Course> getCourseByDepAndSem(int depId, int semId);

}

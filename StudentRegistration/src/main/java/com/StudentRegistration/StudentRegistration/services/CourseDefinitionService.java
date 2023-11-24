package com.StudentRegistration.StudentRegistration.services;

import com.StudentRegistration.StudentRegistration.model.CourseDefinition;

import java.util.List;
import java.util.Optional;

public interface CourseDefinitionService {

    boolean saveDefinition(CourseDefinition courseDefinition);
    List<CourseDefinition> getAllCoursesDefinition();

    boolean deleteCourseDefinition(CourseDefinition courseDefinition);

    Optional<CourseDefinition> getCourseDefinitionById(long id);

    CourseDefinition getCourseDefinitionByName(String name);

}

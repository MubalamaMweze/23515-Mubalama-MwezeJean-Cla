package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.CourseDefinition;
import com.StudentRegistration.StudentRegistration.repository.CourseDefinitionRepository;
import com.StudentRegistration.StudentRegistration.services.CourseDefinitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseDefinitionServiceImplimentation implements CourseDefinitionService {
    /**
     * @param courseDefinition
     * @return
     */
    public final CourseDefinitionRepository courseDefinitionRepository;

    @Override
    public boolean saveDefinition(CourseDefinition courseDefinition) {
        Boolean response = false;
        courseDefinitionRepository.save(courseDefinition);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<CourseDefinition> getAllCoursesDefinition() {
        Boolean response = false;
        List<CourseDefinition> courseDefinitionList = courseDefinitionRepository.findAll();
        response = true;
        return courseDefinitionList;
    }

    /**
     * @param courseDefinition
     * @return
     */
    @Override
    public boolean deleteCourseDefinition(CourseDefinition courseDefinition) {
        Boolean response = false;
        courseDefinitionRepository.delete(courseDefinition);
        response = true;
        return response;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<CourseDefinition> getCourseDefinitionById(long id) {
        Boolean response = false;
        Optional<CourseDefinition> courseDefinition = courseDefinitionRepository.findById(id);
        response = true;
        return courseDefinition;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public CourseDefinition getCourseDefinitionByName(String name) {
        return null;
    }
}

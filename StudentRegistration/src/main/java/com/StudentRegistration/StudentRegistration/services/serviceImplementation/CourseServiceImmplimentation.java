package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.Course;
import com.StudentRegistration.StudentRegistration.repository.CourseRepository;
import com.StudentRegistration.StudentRegistration.services.CourseServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class CourseServiceImmplimentation implements CourseServices {
    /**
     * @param course
     * @return
     */
    public final CourseRepository courseRepository;
    @Override
    public boolean saveCourses(Course course) {
        Boolean response = false;
        courseRepository.save(course);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<Course> getALlCourses() {
        Boolean response = false;
        List<Course> courseList = courseRepository.findAll();
        response = true;
        return courseList;
    }

    /**
     * @param course
     * @return
     */
    @Override
    public boolean deleteCourse(Course course) {
        Boolean response = false;
        courseRepository.delete(course);
        response = true;
        return response;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Course> getCourseDefinition(int id) {
        Boolean response = false;
        Optional<Course> course = courseRepository.findById(id);
        response = true;
        return course;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Course> getCourseById(int id) {
        Boolean response = false;
        Optional<Course> course = courseRepository.findById(id);
        response = true;
        return course;
    }

    /**
     * @param depId
     * @param semId
     * @return
     */
    @Override
    public List<Course> getCourseByDepAndSem(int depId, int semId) {
        return null;
    }
}

package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.StudentCourse;
import com.StudentRegistration.StudentRegistration.repository.StudentCourseRepository;
import com.StudentRegistration.StudentRegistration.services.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
@RequiredArgsConstructor
public class StudentCourseServiceImplimentation implements StudentCourseService {
    /**
     * @param course
     * @return
     */
    public final StudentCourseRepository studentCourseRepository;
    @Override
    public boolean insertStudentCourse(StudentCourse course) {
        Boolean response = false;
        studentCourseRepository.save(course);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<StudentCourse> studentCourseList() {
        Boolean response = false;
        List<StudentCourse> courseList =  studentCourseRepository.findAll();
        response = true;
        return courseList;
    }

    /**
     * @param course
     * @return
     */
    @Override
    public boolean deleteStudentCourse(StudentCourse course) {
        Boolean response = false;
        studentCourseRepository.delete(course);
        response = true;
        return response;
    }

    /**
     * @param id
     * @return
     */
    public Optional<StudentCourse> courseByStudentId(int id) {Boolean response = false;
        Optional<StudentCourse> studentCourse =  studentCourseRepository.findById(id);
        response = true;
        return studentCourse;
    }

    /**
     * @param smId
     * @param crId
     * @return
     */
    @Override
    public List<StudentCourse> studentBySemAndCourse(UUID smId, int crId) {
        return null;
    }
}

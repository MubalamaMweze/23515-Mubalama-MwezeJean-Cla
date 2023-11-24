package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.Student;
import com.StudentRegistration.StudentRegistration.repository.StudentRepository;
import com.StudentRegistration.StudentRegistration.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImplimentation implements StudentServices {
    /**
     * @param student
     * @return
     */

    public final StudentRepository studentRepository;
    @Override
    public boolean saveStudent(Student student) {
        Boolean response = false;
        studentRepository.save(student);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<Student> studentList() {
        Boolean response = false;
        List<Student> studentList =  studentRepository.findAll();
        response = true;
        return studentList;
    }

    /**
     * @param student
     * @return
     */
    @Override
    public boolean deleteStudent(Student student) {
        Boolean response = false;
        studentRepository.delete(student);
        response = true;
        return response;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Student> findStudentById(int id) {
        Boolean response = false;
        Optional<Student> student =  studentRepository.findById(id);
        response = true;
        return student;
    }

    /**
     * @param regNo
     * @return
     */
    @Override
    public Student findStudentByRegNo(String regNo) {
        return null;
    }
}

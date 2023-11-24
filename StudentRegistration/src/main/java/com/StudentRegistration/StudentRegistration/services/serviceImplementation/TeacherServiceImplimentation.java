package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.Teacher;
import com.StudentRegistration.StudentRegistration.repository.TeacherRepository;
import com.StudentRegistration.StudentRegistration.services.TeacherServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImplimentation implements TeacherServices {
    /**
     * @param teacher
     * @return
     */
    public final TeacherRepository teacherRepository;
    @Override
    public boolean addTeacher(Teacher teacher) {
        Boolean response = false;
        teacherRepository.save(teacher);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<Teacher> teacherList() {
        Boolean response = false;
        List<Teacher> teacherList =  teacherRepository.findAll();
        response = true;
        return teacherList;
    }

    /**
     * @param teacher
     * @return
     */
    @Override
    public boolean deleteTeacher(Teacher teacher) {
        Boolean response = false;
        teacherRepository.delete(teacher);
        response = true;
        return response;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Teacher findTeacherByName(String name) {
        return null;
    }
}

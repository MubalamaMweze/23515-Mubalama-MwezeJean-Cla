package com.StudentRegistration.StudentRegistration.services;

import com.StudentRegistration.StudentRegistration.model.Teacher;

import java.util.List;

public interface TeacherServices {

    public boolean addTeacher(Teacher teacher);

    public List<Teacher> teacherList();

    public boolean deleteTeacher(Teacher teacher);

    public Teacher findTeacherByName(String name);

}

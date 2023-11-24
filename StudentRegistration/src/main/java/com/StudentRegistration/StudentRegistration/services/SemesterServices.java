package com.StudentRegistration.StudentRegistration.services;

import com.StudentRegistration.StudentRegistration.model.Semester;

import java.util.List;
import java.util.Optional;

public interface SemesterServices {
    public boolean addSemester(Semester semester);


    public List<Semester> semesterList();

    public Optional<Semester> findSemesterByName(String name);


}

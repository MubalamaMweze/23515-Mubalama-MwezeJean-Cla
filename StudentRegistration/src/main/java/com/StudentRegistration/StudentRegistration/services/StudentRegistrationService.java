package com.StudentRegistration.StudentRegistration.services;

import com.StudentRegistration.StudentRegistration.model.StudentRegistration;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StudentRegistrationService {

    public boolean createStudentRegistration(StudentRegistration registration);

    public List<StudentRegistration> registrationList();

    public boolean deleteStudentRegistration(StudentRegistration registration);

    public StudentRegistration studRegistrationById(int id);

    public List<StudentRegistration> getStudentBySemesterAndDepartment(int semId, int unitId);

    public Optional<StudentRegistration> getStudentBySemester(int id);





}

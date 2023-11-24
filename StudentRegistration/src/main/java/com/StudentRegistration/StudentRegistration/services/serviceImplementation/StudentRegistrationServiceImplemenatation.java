package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.StudentRegistration;
import com.StudentRegistration.StudentRegistration.repository.StudentRegistrationRepository;
import com.StudentRegistration.StudentRegistration.services.StudentRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentRegistrationServiceImplemenatation implements StudentRegistrationService {

    /**
     * @param course
     * @return
     */

    public final StudentRegistrationRepository studentRegistrationRepository;

    /**
     * @param registration
     * @return
     */
    @Override
    public boolean createStudentRegistration(StudentRegistration registration) {
        Boolean response = false;
        studentRegistrationRepository.save(registration);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<StudentRegistration> registrationList() {
        Boolean response = false;
        List<StudentRegistration> studentRegistrationList =  studentRegistrationRepository.findAll();
        response = true;
        return studentRegistrationList;
    }

    /**
     * @param registration
     * @return
     */
    @Override
    public boolean deleteStudentRegistration(StudentRegistration registration) {
        Boolean response = false;
        studentRegistrationRepository.delete(registration);
        response = true;
        return response;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public StudentRegistration studRegistrationById(int id) {
        return null;
    }

    /**
     * @param semId
     * @param unitId
     * @return
     */
    @Override
    public List<StudentRegistration> getStudentBySemesterAndDepartment(int semId, int unitId) {
        return null;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<StudentRegistration> getStudentBySemester(int id) {
        Boolean response = false;
        Optional<StudentRegistration> studreg =  studentRegistrationRepository.findById(id);
        response = true;
        return studreg;

    }
}

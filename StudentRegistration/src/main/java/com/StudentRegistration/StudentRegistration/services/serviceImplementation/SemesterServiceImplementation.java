package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.Semester;
import com.StudentRegistration.StudentRegistration.repository.SemesterRepository;
import com.StudentRegistration.StudentRegistration.services.SemesterServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SemesterServiceImplementation implements SemesterServices {
    /**
     * @param semester
     * @return
     */
    public final SemesterRepository semesterRepository;
    @Override
    public boolean addSemester(Semester semester) {
        Boolean response = false;
        semesterRepository.save(semester);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<Semester> semesterList() {
        Boolean response = false;
        List<Semester> courses = semesterRepository.findAll();
        response = true;
        return courses;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public Optional<Semester> findSemesterByName(String name) {   Boolean response = false;
        Optional<Semester> semester = Optional.ofNullable(semesterRepository.findByName(name));
        response = true;
        return semester;
    }
}

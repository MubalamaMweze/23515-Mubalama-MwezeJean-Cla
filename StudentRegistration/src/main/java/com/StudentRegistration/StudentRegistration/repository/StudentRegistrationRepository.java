package com.StudentRegistration.StudentRegistration.repository;

import com.StudentRegistration.StudentRegistration.model.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface StudentRegistrationRepository  extends JpaRepository<StudentRegistration, Integer> {
//    List<StudentRegistration> findBy_semester_IdAndUnit_Id(UUID semId, int unitId);

//    List<StudentRegistration> findBySemester_Id(UUID id);
}

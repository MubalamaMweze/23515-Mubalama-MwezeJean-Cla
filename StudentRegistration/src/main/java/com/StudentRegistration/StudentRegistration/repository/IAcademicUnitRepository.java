package com.StudentRegistration.StudentRegistration.repository;

import com.StudentRegistration.StudentRegistration.model.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAcademicUnitRepository extends JpaRepository<AcademicUnit,Integer> {
     AcademicUnit findByName(String unitName);

}

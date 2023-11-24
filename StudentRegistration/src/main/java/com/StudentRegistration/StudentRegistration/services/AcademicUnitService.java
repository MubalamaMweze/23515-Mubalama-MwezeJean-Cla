package com.StudentRegistration.StudentRegistration.services;


import com.StudentRegistration.StudentRegistration.model.AcademicUnit;

import java.util.List;
import java.util.Optional;

public interface AcademicUnitService {
    public boolean saveAcademic(AcademicUnit academicUnit);

    public List<AcademicUnit> getAllAcademicUnits();

    public boolean deleteUnit(AcademicUnit unit);

    public AcademicUnit findUnitByName(String name);

    public Optional<AcademicUnit> findUnitById(int id);




}

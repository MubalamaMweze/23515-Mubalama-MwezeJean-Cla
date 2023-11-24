package com.StudentRegistration.StudentRegistration.services.serviceImplementation;

import com.StudentRegistration.StudentRegistration.model.AcademicUnit;
import com.StudentRegistration.StudentRegistration.repository.IAcademicUnitRepository;
import com.StudentRegistration.StudentRegistration.services.AcademicUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AcademicServiceImplimentation implements AcademicUnitService {
    /**
     * @param academicUnit
     * @return
     */

    public final IAcademicUnitRepository iAcademicUnitRepository;




    @Override
    public boolean saveAcademic(AcademicUnit academicUnit) {
        Boolean response = false;
            iAcademicUnitRepository.save(academicUnit);
        response = true;
        return response;
    }

    /**
     * @return
     */
    @Override
    public List<AcademicUnit> getAllAcademicUnits() {
        List<AcademicUnit> accademic  = iAcademicUnitRepository.findAll();
        return accademic;
    }

    /**
     * @param unit
     * @return
     */
    @Override
    public boolean deleteUnit(AcademicUnit unit) {
        Boolean response = false;
        iAcademicUnitRepository.delete(unit);
        response = true;
        return response;
    }

    /**
     * @param name
     * @return
     */
    @Override
    public AcademicUnit findUnitByName(String name) {
        Boolean response = false;
       AcademicUnit academicUnit =  iAcademicUnitRepository.findByName(name);
        response = true;
        return academicUnit;
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<AcademicUnit> findUnitById(int id) {
        Boolean response = false;
        Optional<AcademicUnit> academicUnit =  iAcademicUnitRepository.findById(id);
        response = true;
        return academicUnit;
    }
}

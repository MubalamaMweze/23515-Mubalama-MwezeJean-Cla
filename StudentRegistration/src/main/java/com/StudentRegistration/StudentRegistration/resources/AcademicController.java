package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.AcademicUnit;
import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.AcademicServiceImplimentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Map;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AcademicController {

    private final AcademicServiceImplimentation academicServiceImplimentation;


    @PostMapping("/saveAcademic")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody AcademicUnit academicUnit) throws InterruptedException{

        academicServiceImplimentation.saveAcademic(academicUnit);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
    @PutMapping ("/updateAcademic/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException{AcademicUnit academicUnit = new AcademicUnit();
        AcademicUnit academicU = new AcademicUnit();
        academicU.setId(id);
        academicServiceImplimentation.saveAcademic(academicU);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }
    @PostMapping("/deleteAcademic/{id}")
    public ResponseEntity<HttpResponse> deleteMethod(@PathVariable int academicUnit) throws InterruptedException{
        AcademicUnit academicUnit1 = new AcademicUnit();
        academicUnit1.setId(academicUnit);
        academicServiceImplimentation.deleteUnit(academicUnit1);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


    @GetMapping("/academicList")
    public ResponseEntity<HttpResponse> findAllAcademic() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Read successfully")
                        .data(Map.of("AcademicList",academicServiceImplimentation.getAllAcademicUnits()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/academic/{id}")
    public ResponseEntity<HttpResponse> findAcademic(@PathVariable int id) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("AcademicList",academicServiceImplimentation.findUnitById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }




}

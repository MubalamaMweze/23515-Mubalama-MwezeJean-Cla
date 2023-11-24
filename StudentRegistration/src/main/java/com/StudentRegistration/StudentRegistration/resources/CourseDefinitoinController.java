package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.AcademicUnit;
import com.StudentRegistration.StudentRegistration.model.Course;
import com.StudentRegistration.StudentRegistration.model.CourseDefinition;
import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.CourseDefinitionServiceImplimentation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CourseDefinitoinController {

    private final CourseDefinitionServiceImplimentation definitionServiceImplimentation;

    @PostMapping("/savecoursedefinition")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody CourseDefinition courseDefinition) throws InterruptedException{

        definitionServiceImplimentation.saveDefinition(courseDefinition);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/deletecourseDefinition/{id}")
    public ResponseEntity<HttpResponse> deleteMethod(@PathVariable Long cdfId) throws InterruptedException{
        CourseDefinition courseDefinition = new CourseDefinition();
        courseDefinition.setId(cdfId);
        definitionServiceImplimentation.deleteCourseDefinition(courseDefinition);

        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PutMapping ("/updateCourseDefinition/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException{
        CourseDefinition courseDefinition = new CourseDefinition();
        courseDefinition.setId(id);
        definitionServiceImplimentation.saveDefinition(courseDefinition);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/courseDefinitionList")
    public ResponseEntity<HttpResponse> findcourseDefinition() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data fetched successfully")
                        .data(Map.of("coursedList",definitionServiceImplimentation.getAllCoursesDefinition()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/courseDefinition/{id}")
    public ResponseEntity<HttpResponse> findAcademic(@PathVariable Long id) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("courseDef",definitionServiceImplimentation.getCourseDefinitionById(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }



}

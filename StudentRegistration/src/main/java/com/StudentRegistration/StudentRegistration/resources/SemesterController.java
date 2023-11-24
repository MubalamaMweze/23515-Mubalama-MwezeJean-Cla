package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.Course;
import com.StudentRegistration.StudentRegistration.model.CourseDefinition;
import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.model.Semester;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.SemesterServiceImplementation;
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
public class SemesterController {

    private final SemesterServiceImplementation semesterServiceImplementation;
    @PostMapping("/saveSemester")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody Semester semester) throws InterruptedException{

        semesterServiceImplementation.addSemester(semester);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PutMapping ("/updateSemester/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException {
        Semester semester = new Semester();
        semester.setId(id);
        semesterServiceImplementation.addSemester(semester);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


    @GetMapping("/semesterList")
    public ResponseEntity<HttpResponse> findSemester() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data fetched successfully")
                        .data(Map.of("semesterList", semesterServiceImplementation.semesterList()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/semester/{id}")
    public ResponseEntity<HttpResponse> findSemester(@PathVariable String name) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("semester", semesterServiceImplementation.findSemesterByName(name)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

}

package com.StudentRegistration.StudentRegistration.resources;

import com.StudentRegistration.StudentRegistration.model.HttpResponse;
import com.StudentRegistration.StudentRegistration.model.Semester;
import com.StudentRegistration.StudentRegistration.model.StudentCourse;
import com.StudentRegistration.StudentRegistration.services.serviceImplementation.StudentCourseServiceImplimentation;
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
public class StudentCourseController {

    private final StudentCourseServiceImplimentation studentCourseServiceImplimentation;


    @PostMapping("/saveStudentCourse")
    public ResponseEntity<HttpResponse> saveMethod(@RequestBody StudentCourse stdCourse) throws InterruptedException{
        studentCourseServiceImplimentation.insertStudentCourse(stdCourse);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data saved successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PostMapping("/deleteStdCourse/{id}")
    public ResponseEntity<HttpResponse> deleteMethod(@PathVariable int stdc) throws InterruptedException{
        StudentCourse course = new StudentCourse();
        course.setId(stdc);
        studentCourseServiceImplimentation.deleteStudentCourse(course);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data deleted successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @PutMapping ("/updateStudentCourse/{id}")
    public ResponseEntity<HttpResponse> updateMethod(@PathVariable int id) throws InterruptedException {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setId(id);
        studentCourseServiceImplimentation.deleteStudentCourse(studentCourse);
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data Update successfully")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


    @GetMapping("/stdCourseList")
    public ResponseEntity<HttpResponse> findStudentCourse() throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data fetched successfully")
                        .data(Map.of("stdCoursedList",studentCourseServiceImplimentation.studentCourseList()))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }

    @GetMapping("/StdCourse/{id}")
    public ResponseEntity<HttpResponse> findAcademic(@PathVariable int id) throws InterruptedException{
        return ResponseEntity.ok().body(
                HttpResponse.builder()
                        .timesStamp(LocalTime.now().toString())
                        .message("data found successfully")
                        .data(Map.of("course",studentCourseServiceImplimentation.courseByStudentId(id)))
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build());
    }


}
